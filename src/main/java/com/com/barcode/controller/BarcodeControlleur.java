package com.com.barcode.controller;

import java.util.Objects;

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
            printDevice.print("No price scanned : Invalid barcode");
            return;
        }
        Double itemPrice = priceGateWay.findByCodeBar(code);
        if(isNull(itemPrice)){
            printDevice.print(String.format("No price found for %s", code));
        }else {
            printDevice.print(code, itemPrice);
        }
    }
}
