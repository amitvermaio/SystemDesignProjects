package service;

import model.Inventory;
import model.Product;
import model.ProductType;

public class InventoryService {

    private Inventory inventory;

    public InventoryService(Inventory inventory) {
        this.inventory = inventory;
    }

    public void addProduct(Product product, int quantity) {
        inventory.addProduct(product, quantity);
    }

    public Product getProduct(ProductType type) {
        return inventory.getProduct(type);
    }

    public boolean isAvailable(ProductType type) {
        return inventory.isAvailable(type);
    }

    public void reduceStock(ProductType type) {
        inventory.reduceStock(type);
    }

    public void displayProducts() {
        inventory.displayProducts();
    }
}