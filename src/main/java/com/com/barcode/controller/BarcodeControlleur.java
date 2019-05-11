package com.com.barcode.controller;

import java.util.Objects;

public class BarcodeControlleur {

    private PriceGateWay priceGateWay;

    public BarcodeControlleur(PriceGateWay priceGateWay) {
        this.priceGateWay = priceGateWay;
    }

    public void onBarcode(String code) {
        if(Objects.isNull(code) || code.isEmpty()){
            throw new InvalidBarcodeException("Invalid Barcode");
        }
        double itemPrice = priceGateWay.findByCodeBar(code);
        System.out.println(itemPrice);
    }
}
