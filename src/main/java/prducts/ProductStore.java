package prducts;

import com.rmalvadkar.sck.AddProductRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductStore {

   private static final Map<String,Product> items = new HashMap();

   public static Map<String, Product> getItems(){
       return items;
   }

    public static List<String> items() {
        return List.of();
    }

    public static void clearTheItem(){
       items.clear();
    }

    public static Product findProductBy(String productCode) {
       return items.get(productCode);
    }

    public static void addProductInProductStore(AddProductRequest newProduct) {

       if(isProduct(newProduct)){
           addNewProductInStore(newProduct);
       }
       else{
           productExistAddQuantityOfExistingProduct(newProduct);
       }
    }

    private static boolean isProduct(AddProductRequest newProduct) {
        return !items.containsKey(newProduct.productCode());
    }

    private static void productExistAddQuantityOfExistingProduct(AddProductRequest newProduct) {
        Product product = items.get(newProduct.productCode());
        product.setQuantity(product.quantity() + 1);

        items.put(product.productCode(), product);
    }

    private static void addNewProductInStore(AddProductRequest newProduct) {
        Product product = Product.of(newProduct.name(), 1, newProduct.productCode(), newProduct.price());
        items.put(product.productCode(), product);
    }
}
