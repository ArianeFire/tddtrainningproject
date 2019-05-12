package com.com.barcode.controller;

public interface PrintDevice {
    void printPrice(Double price);
    String getText();
    void print(String s);
}
