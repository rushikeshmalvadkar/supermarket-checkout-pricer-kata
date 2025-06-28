package com.rmalvadkar.sck.prducts;

import java.math.BigDecimal;

public record ProductInput(String name, String productCode, BigDecimal price) {

    public static ProductInput of(String name, String productCode, BigDecimal price){
        return new ProductInput(name,productCode,price);
    }

}
