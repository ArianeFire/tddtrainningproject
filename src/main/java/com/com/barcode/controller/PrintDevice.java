package com.com.barcode.controller;

public interface PrintDevice {
    void printPrice(Double price);

    void printInvalidCodeBar();

    String getText();
    void print(String s);
}
