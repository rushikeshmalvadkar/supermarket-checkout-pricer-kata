package prducts;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public class ProductStoreTest {

      @BeforeEach
      void setUp(){
         ProductStore.clear();
      }

    @Test
    void should_return_empty_list_of_product_if_no_product_exist_in_the_store() {
        List<String> products = ProductStore.items();
        Assertions.assertThat(products).isEmpty();
    }


    @Test
    void should_get_product_by_product_code() {
        ProductInput newProduct = ProductInput.of("maggi", "M001", new BigDecimal("10"));
        ProductStore.add(newProduct);
        Product product = ProductStore.findProductBy("M001");
        Assertions.assertThat(product.name()).isEqualTo("maggi");
    }


    @Test
    void should_add_product_in_product_store() {
        ProductInput firstProduct = ProductInput.of("maggi", "M001", new BigDecimal("10"));
        ProductInput secondProduct = ProductInput.of("parle", "M002", new BigDecimal("10"));
        ProductStore.add(firstProduct);
        ProductStore.add(secondProduct);
        Collection<Product> productList = ProductStore.getProductCodeToProductMap();
        Assertions.assertThat(productList.size()).isEqualTo(2);
        Assertions.assertThat(productList.stream().findFirst().get().quantity()).isEqualTo(1);
    }

}
