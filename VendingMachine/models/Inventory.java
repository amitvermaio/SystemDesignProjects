package VendingMachine.models;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private final Map<Product, Slot> slots = new HashMap<>();

    public void addProduct(Product product, int quantity) {

        if (slots.containsKey(product)) {
            slots.get(product).addQuantity(quantity);
        } else {
            slots.put(product, new Slot(product, quantity));
        }
    }

    public Slot getSlot(Product product) {
        return slots.get(product);
    }

    public boolean hasProduct(Product product) {
        Slot slot = slots.get(product);
        return slot != null && slot.isAvailable();
    }

    public void dispense(Product product) {
        Slot slot = slots.get(product);

        if (slot != null) {
            slot.reduceQuantity(1);
        }
    }

    public void displayInventory() {
        for (Slot slot : slots.values()) {
            System.out.println(slot);
        }
    }
}