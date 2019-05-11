package com.com.barcode.controller;

public class InvalidBarcodeException extends RuntimeException {

    public InvalidBarcodeException(String message){
        super(message);
    }
}
