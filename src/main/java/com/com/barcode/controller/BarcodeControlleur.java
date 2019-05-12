package com.com.barcode.controller;

import java.util.Objects;

public class BarcodeControlleur {

    private PriceGateWay priceGateWay;
    private PrintDevice printDevice;

    public BarcodeControlleur(PriceGateWay priceGateWay, PrintDevice printDevice) {
        this.priceGateWay = priceGateWay;
        this.printDevice = printDevice;
    }

    public void onBarcode(String code) {
        if(Objects.isNull(code) || code.isEmpty()){
            printDevice.print("No price scanned : Invalid barcode");
            return;
        }
        double itemPrice = priceGateWay.findByCodeBar(code);
        printDevice.print(code, itemPrice);
    }
}
