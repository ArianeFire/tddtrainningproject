package com.com.barcode.controller;

import java.util.Map;

public class InMemoryPriceGateway implements PriceGateWay{

    private Map<String, Double> codebarByPrice;

    public InMemoryPriceGateway(Map<String, Double> codebarByPrice){
        this.codebarByPrice = codebarByPrice;
    }

    @Override
    public Double findByCodeBar(String code) {
        return codebarByPrice.get(code);
    }
}
