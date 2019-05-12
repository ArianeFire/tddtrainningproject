package com.com.barcode.controller;

public class RemenberPrinter implements PrintDevice{
    private String message;
    @Override
    public void print(String codebar, double price) {
        this.message = String.format("%s%s", codebar, price);
    }

    @Override
    public String getText() {
        return message;
    }

    @Override
    public void print(String s) {
        this.message = s;
    }

    public String getMessage() {
        return message;
    }
}
