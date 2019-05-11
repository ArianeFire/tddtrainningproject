package com.barcode.controller.test;

import com.com.barcode.controller.BarcodeControlleur;
import com.com.barcode.controller.InvalidBarcodeException;
import com.com.barcode.controller.NoPriceFoundException;
import com.com.barcode.controller.PriceGateWay;
import org.junit.Before;
import org.junit.Test;

public class BarCodeControllerTest {

    private PriceGateWay priceGateWay;
    private BarcodeControlleur barcodeControlleur;

    @Before
    public void before(){
        priceGateWay = new StaticPriceGateway();
        barcodeControlleur = new BarcodeControlleur(priceGateWay);
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
        barcodeControlleur = new BarcodeControlleur(priceGateWay);
        barcodeControlleur.onBarcode("0101");
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
}
