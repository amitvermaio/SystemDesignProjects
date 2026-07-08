package model;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private Map<ProductType, Integer> stock = new HashMap<>();
    private Map<ProductType, Product> products = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        products.put(product.getType(), product);
        stock.put(product.getType(),
                stock.getOrDefault(product.getType(), 0) + quantity);
    }

    public Product getProduct(ProductType type) {
        return products.get(type);
    }

    public int getQuantity(ProductType type) {
        return stock.getOrDefault(type, 0);
    }

    public void reduceStock(ProductType type) {
        int qty = stock.get(type);
        stock.put(type, qty - 1);
    }

    public boolean isAvailable(ProductType type) {
        return stock.getOrDefault(type, 0) > 0;
    }

    public void displayProducts() {

        System.out.println("\n===== Available Products =====");

        for (Product product : products.values()) {

            System.out.println(
                    product.getType() +
                            " | " +
                            product.getName() +
                            " | ₹" +
                            product.getPrice() +
                            " | Qty : " +
                            stock.get(product.getType())
            );
        }

        System.out.println();
    }
}