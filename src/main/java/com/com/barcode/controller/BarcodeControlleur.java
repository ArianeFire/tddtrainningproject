package com.com.barcode.controller;

import static java.util.Objects.isNull;

public class BarcodeControlleur {

    private PriceGateWay priceGateWay;
    private PrintDevice printDevice;

    public BarcodeControlleur(PriceGateWay priceGateWay, PrintDevice printDevice) {
        this.priceGateWay = priceGateWay;
        this.printDevice = printDevice;
    }

    public void onBarcode(String code) {
        if(isNull(code) || code.isEmpty()){
            printDevice.printInvalidCodeBar();
            return;
        }
        Double itemPrice = priceGateWay.findByCodeBar(code);
        if(isNull(itemPrice)){
            printDevice.printPriceNotFoundForCodebar(code);
        }else {
            printDevice.printPrice(itemPrice);
        }
    }
}
