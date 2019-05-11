package com.barcode.controller.test;

import com.com.barcode.controller.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class BarCodeControllerTest {

    private PriceGateWay priceGateWay;
    private PrintDevice printDevice;
    private BarcodeControlleur barcodeControlleur;

    @Before
    public void before(){
        printDevice = new RemenberPrinter();
        priceGateWay = new StaticPriceGateway();
        barcodeControlleur = new BarcodeControlleur(priceGateWay, printDevice);
    }

    @Test(expected =  InvalidBarcodeException.class)
    public void on_Null_Barcode_Receive(){
        barcodeControlleur.onBarcode(null);
    }

    @Test(expected = InvalidBarcodeException.class)
    public void on_Empty_Barcode_Receive(){
        barcodeControlleur.onBarcode("");
    }

    @Test(expected = NoPriceFoundException.class)
    public void no_Price_Found_For_Codebar(){
        priceGateWay = new InvalidPriceGateway();
        barcodeControlleur = new BarcodeControlleur(priceGateWay, printDevice);
        barcodeControlleur.onBarcode("0101");
    }

    @Test
    public void display_Item_Price(){
        barcodeControlleur.onBarcode("0A0A0A01010");
        assertNotNull(((RemenberPrinter)printDevice).getMessage());
    }


    class InvalidPriceGateway implements PriceGateWay {
        @Override
        public double findByCodeBar(String code) {
            throw new NoPriceFoundException();
        }
    }

    class StaticPriceGateway implements PriceGateWay {
        @Override
        public double findByCodeBar(String code) {
            return 0;
        }
    }

    class RemenberPrinter implements PrintDevice{
        private String message;
        @Override
        public void print(String codebar, double price) {
            this.message = String.format("%s%s", codebar, price);
        }
        public String getMessage() {
            return message;
        }
    }
}
