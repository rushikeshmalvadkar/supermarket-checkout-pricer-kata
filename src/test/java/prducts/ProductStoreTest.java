package prducts;

import com.rmalvadkar.sck.AddProductRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static prducts.ProductStore.addProductInProductStore;

public class ProductStoreTest {

      @BeforeEach
      void setUp(){
         ProductStore.clearTheItem();
      }

    @Test
    void should_return_empty_list_of_product_if_no_product_exist_in_the_store() {

        List<String> products = ProductStore.items();
        Assertions.assertThat(products).isEmpty();
        ;
    }


    @Test
    void should_get_product_by_product_code() {
        AddProductRequest newProduct = AddProductRequest.of("maggi", "M001", new BigDecimal("10"));
        addProductInProductStore(newProduct);
        Product product = ProductStore.findProductBy("M001");
        Assertions.assertThat(product.name()).isEqualTo("maggi");
        ;
    }


    @Test
    void should_add_product_in_product_store() {
        AddProductRequest newProduct = AddProductRequest.of("maggi", "M001", new BigDecimal("10"));
        addProductInProductStore(newProduct);
        addProductInProductStore(newProduct);

        Map<String, Product> items = ProductStore.getItems();
        Product product = items.get(newProduct.productCode());
        Assertions.assertThat(items.get(newProduct.productCode()).quantity()).isEqualTo(2);
        ;
    }



}
