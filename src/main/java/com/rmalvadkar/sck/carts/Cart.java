package com.rmalvadkar.sck.carts;

import com.rmalvadkar.sck.prducts.Product;
import com.rmalvadkar.sck.prducts.ProductStore;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    private final Map<String, ProductItem> productCodeTOProductItem = new HashMap<>();

    public Collection<ProductItem> items() {
        return productCodeTOProductItem.values();
    }

    public void scan(String productCode) {
        Product product = ProductStore.findProductBy(productCode);
        if(productExitBy(productCode)){
            updateAlreadyExitProduct(productCode, product);
            return;
        }

        productCodeTOProductItem.put(productCode, new ProductItem(productCode, product.price(),1));
    }

    private boolean productExitBy(String productCode) {
        return productCodeTOProductItem.containsKey(productCode);
    }

    private void updateAlreadyExitProduct(String productCode, Product product) {
        ProductItem productItem = productCodeTOProductItem.get(productCode);
        productCodeTOProductItem.put(productCode,productItem.incrementQuantity());
        return;
    }

    public BigDecimal totalPrice() {
      return productCodeTOProductItem.values()
               .stream()
               .map(ProductItem::priceWithQuality)
               .reduce(BigDecimal.ZERO,BigDecimal::add);
    }
}
