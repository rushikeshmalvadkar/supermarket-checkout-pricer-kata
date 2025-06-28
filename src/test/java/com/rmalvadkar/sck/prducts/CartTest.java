package com.rmalvadkar.sck.prducts;

import com.rmalvadkar.sck.carts.Cart;
import com.rmalvadkar.sck.carts.ProductItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class CartTest {

    @BeforeEach
    void setUp() {
        ProductStore.clear();
    }

    @Test
    void should_return_zero_items_if_cart_is_empty() {
        Cart cart = new Cart();

        Collection<ProductItem> items = cart.items();

        assertThat(items).isEmpty();
    }


    @Test
    void should_return_total_amount_after_scan_single_product_from_cart() {
        ProductStore.add(ProductInput.of("maggi", "P001", new BigDecimal(("100"))));
        Cart cart = new Cart();

        cart.scan("P001");

        assertThat(cart.totalPrice()).isEqualTo(new BigDecimal("100"));
        assertThat(cart.items()).hasSize(1);
    }

    @Test
    void should_return_total_amount_after_scan_multi_product_and_if_product_same_scan_from_cart() {
        ProductStore.add(ProductInput.of("maggi", "P001", new BigDecimal("200")));
        ProductStore.add(ProductInput.of("ooat", "P002", new BigDecimal("200")));
        ProductStore.add(ProductInput.of("puri", "P003", new BigDecimal("100")));
        Cart cart = new Cart();

        cart.scan("P001");
        cart.scan("P001");
        cart.scan("P002");
        cart.scan("P002");
        cart.scan("P003");


        assertThat(cart.totalPrice()).isEqualTo(new BigDecimal("900"));
        assertThat(cart.items()).hasSize(3);
    }




}
