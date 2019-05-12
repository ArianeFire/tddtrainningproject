package com.com.barcode.controller;

public interface PrintDevice {
    void print(String codebar, double price);
    String getText();
    void print(String s);
}
