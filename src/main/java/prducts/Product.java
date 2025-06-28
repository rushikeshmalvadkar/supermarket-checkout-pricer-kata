package prducts;

import java.math.BigDecimal;
import java.util.Objects;

public  class Product {
    private  String name;
    private  Integer quantity;
    private  String productCode;
    private  BigDecimal price;



    public Product(String name, Integer quantity, String productCode, BigDecimal price) {
        this.name = name;
        this.quantity = quantity;
        this.productCode = productCode;
        this.price = price;
    }

    public static Product of(String name, Integer quantity, String productCode, BigDecimal price) {
        return new Product(name, quantity, productCode, price);
    }

    public String name() {
        return name;
    }

    public Integer quantity() {
        return quantity;
    }

    public String productCode() {
        return productCode;
    }

    public BigDecimal price() {
        return price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Product) obj;
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.quantity, that.quantity) &&
                Objects.equals(this.productCode, that.productCode) &&
                Objects.equals(this.price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantity, productCode, price);
    }

    @Override
    public String toString() {
        return "Product[" +
                "name=" + name + ", " +
                "quantity=" + quantity + ", " +
                "productCode=" + productCode + ", " +
                "price=" + price + ']';
    }


}
