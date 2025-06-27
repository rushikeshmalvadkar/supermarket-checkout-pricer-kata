package prducts;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductStore {

   private static final Map<String,Product> PRODUCT_CODE_TO_PRODUCT_MAP = new HashMap<>();

   public static Collection<Product> getProductCodeToProductMap(){
       return PRODUCT_CODE_TO_PRODUCT_MAP.values();
   }

    public static List<String> items() {
        return List.of();
    }

    public static void clear(){
       PRODUCT_CODE_TO_PRODUCT_MAP.clear();
    }

    public static Product findProductBy(String productCode) {
       return PRODUCT_CODE_TO_PRODUCT_MAP.get(productCode);
    }

    public static void add(ProductInput product) {
        if(alreadyDoesNotExists(product)) {
           addProductToStore(product);
           return;
       }
        productExistAddQuantityOfExistingProduct(product);
    }

    private static boolean alreadyDoesNotExists(ProductInput product) {
        return !PRODUCT_CODE_TO_PRODUCT_MAP.containsKey(product.productCode());
    }

    private static void productExistAddQuantityOfExistingProduct(ProductInput newProduct) {
        Product product = PRODUCT_CODE_TO_PRODUCT_MAP.get(newProduct.productCode());
        product.setQuantity(product.quantity() + 1);

        PRODUCT_CODE_TO_PRODUCT_MAP.put(product.productCode(), product);
    }

    private static void addProductToStore(ProductInput newProduct) {
        Product product = Product.of(newProduct.name(), 1, newProduct.productCode(), newProduct.price());
        PRODUCT_CODE_TO_PRODUCT_MAP.put(product.productCode(), product);
    }
}
