package prducts;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProductStoreTest {


    @Test
    void should_return_empty_list_of_product_if_no_product_exist_in_the_store() {

        ProductStore productStore = new ProductStore();
        List<String> products = productStore.items();
        Assertions.assertThat(products).isEmpty();
        ;

    }
}
