package com.barcode.controller.test;

import com.com.barcode.controller.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class BarCodeControllerTest {

    private PriceGateWay priceGateWay;
    private PrintDevice printDevice;
    private BarcodeControlleur barcodeControlleur;

    @Before
    public void before(){
        printDevice = new RemenberPrinter();
        priceGateWay = new InMemoryPriceGateway(new HashMap<String, Double>() {{
            put("1", 12.8);
        }});
        barcodeControlleur = new BarcodeControlleur(priceGateWay, printDevice);
    }

    @Test
    public void on_Null_Barcode_Receive(){
        barcodeControlleur.onBarcode(null);
        assertEquals("No price scanned : Invalid barcode", printDevice.getText());
    }

    @Test
    public void on_Empty_Barcode_Receive(){
        barcodeControlleur.onBarcode("");
        assertEquals("No price scanned : Invalid barcode", printDevice.getText());
    }

    @Test
    public void no_Price_Found_For_Codebar(){
        barcodeControlleur.onBarcode("01");
        assertEquals(String.format("No price found for %s", "01"), printDevice.getText());
    }

    @Test
    public void display_Item_Price(){
        barcodeControlleur.onBarcode("0A0A0A01010");
        assertEquals("10.8", printDevice.getText());
    }
}
