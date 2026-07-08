package VendingMachine.services;

import VendingMachine.models.Inventory;
import VendingMachine.models.Product;

public class InventoryService {

    private final Inventory inventory;

    public InventoryService(Inventory inventory) {
        this.inventory = inventory;
    }

    public void addProduct(Product product, int quantity) {
        inventory.addProduct(product, quantity);
    }

    public boolean isAvailable(Product product) {
        return inventory.hasProduct(product);
    }

    public void dispense(Product product) {
        inventory.dispense(product);
    }

    public void displayInventory() {
        inventory.displayInventory();
    }
}