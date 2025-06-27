package com.rmalvadkar.sck;

import java.math.BigDecimal;

public record AddProductRequest(String name, String productCode, BigDecimal price) {

    public static AddProductRequest of(String name, String productCode, BigDecimal price){
        return new AddProductRequest(name,productCode,price);
    }

}
