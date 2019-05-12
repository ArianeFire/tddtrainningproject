package com.com.barcode.controller;

public class RemenberPrinter implements PrintDevice{
    private String text;
    @Override
    public void printPrice(Double price) {
        this.text = String.format("%s", price);
    }

    @Override
    public void printInvalidCodeBar(){
        print("No price scanned : Invalid barcode");
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void print(String s) {
        this.text = s;
    }
}
