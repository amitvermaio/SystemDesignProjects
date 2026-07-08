package VendingMachine.models;

import VendingMachine.services.InventoryService;
import VendingMachine.services.PaymentService;

public class VendingMachine {

    private static VendingMachine instance;

    private final Inventory inventory;
    private final InventoryService inventoryService;
    private final PaymentService paymentService;

    private VendingMachine() {
        inventory = new Inventory();
        inventoryService = new InventoryService(inventory);
        paymentService = new PaymentService();
    }

    public static VendingMachine getInstance() {

        if (instance == null) {
            instance = new VendingMachine();
        }

        return instance;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public InventoryService getInventoryService() {
        return inventoryService;
    }

    public PaymentService getPaymentService() {
        return paymentService;
    }
}