package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> items = new ArrayList<>();

    public void addProduct(Product product, int quantity) {

    }

    public void removeProduct(ProductType type) {

    }

    public double getTotalPrice() {
        return 0;
    }

    public List<CartItem> getItems() {
        return items;
    }
}