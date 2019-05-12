package com.com.barcode.controller;

public interface PrintDevice {
    void printPrice(Double price);

    void printInvalidCodeBar();

    void printPriceNotFoundForCodebar(String code);

    String getText();
    void print(String s);
}
