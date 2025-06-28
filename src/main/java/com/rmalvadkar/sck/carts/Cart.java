package com.rmalvadkar.sck.carts;

import com.rmalvadkar.sck.prducts.Product;
import com.rmalvadkar.sck.prducts.ProductStore;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    private final Map<String,PrductItem> productCodeTOProductItem = new HashMap<>();

    public Collection<PrductItem> items() {
        return productCodeTOProductItem.values();
    }

    public void scan(String productCode) {
        Product product = ProductStore.findProductBy(productCode);
        if(productCodeTOProductItem.containsKey(productCode)){
            PrductItem prductItem = productCodeTOProductItem.get(productCode);
          productCodeTOProductItem.put(productCode,new PrductItem(prductItem.productCode(), prductItem.productPrice().add(product.price()) ,prductItem.Quantity() + 1));
          return;
        }

        productCodeTOProductItem.put(productCode, new PrductItem(productCode, product.price(),1));
    }

    public BigDecimal totalPrice() {
      return productCodeTOProductItem.values()
               .stream()
               .map(PrductItem::productPrice)
               .reduce(BigDecimal.ZERO,BigDecimal::add);
    }
}
