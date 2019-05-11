package com.barcode.controller.test;

import com.com.barcode.controller.BarcodeControlleur;
import com.com.barcode.controller.InvalidBarcodeException;
import org.junit.Test;

public class BarCodeControllerTest {

    @Test(expected =  InvalidBarcodeException.class)
    public void on_Null_Barcode_Receive(){
        BarcodeControlleur barcodeControlleur = new BarcodeControlleur();
        barcodeControlleur.onBarcode(null);
    }

    @Test(expected = InvalidBarcodeException.class)
    public void on_Empty_Barcode_Receive(){
        BarcodeControlleur barcodeControlleur = new BarcodeControlleur();
        barcodeControlleur.onBarcode("");
    }

}
