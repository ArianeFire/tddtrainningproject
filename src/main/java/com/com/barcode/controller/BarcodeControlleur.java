package com.com.barcode.controller;

import java.util.Objects;

public class BarcodeControlleur {

    public void onBarcode(String code) {
        if(Objects.isNull(code) || code.isEmpty()){
            throw new InvalidBarcodeException("Invalid Barcode");
        }
    }
}
