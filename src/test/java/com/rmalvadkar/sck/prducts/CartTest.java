package com.rmalvadkar.sck.prducts;

import com.rmalvadkar.sck.carts.Cart;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CartTest {

    @Test
    void should_return_zero_items_if_cart_is_empty() {
        Cart cart = new Cart();
        List<String> items = cart.items();
        Assertions.assertThat(items).isEmpty();
    }
}
