package com.rmalvadkar.sck.carts;

import java.math.BigDecimal;

public record ProductItem(String productCode, BigDecimal productPrice, int quantity) {

    public ProductItem incrementQuantity(){
        return new ProductItem(productCode, productPrice, quantity + 1);
    }

    public BigDecimal priceWithQuality(){
        return productPrice.multiply(BigDecimal.valueOf(quantity));
    }

}
