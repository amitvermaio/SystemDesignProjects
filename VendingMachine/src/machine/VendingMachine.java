package machine;

import factory.ProductFactory;
import model.Inventory;
import model.Product;
import model.ProductType;
import payment.PaymentStrategy;
import service.InventoryService;
import state.IdleState;
import state.OutOfStockState;
import state.State;

public class VendingMachine {

    // Singleton Instance
    private static VendingMachine instance;

    // Current State
    private State state;

    // Inventory Service
    private InventoryService inventoryService;

    // Currently Selected Product
    private ProductType selectedProduct;

    // Private Constructor
    private VendingMachine() {

        Inventory inventory = new Inventory();
        inventoryService = new InventoryService(inventory);

        state = new IdleState();

        loadProducts();
    }

    // Singleton
    public static VendingMachine getInstance() {

        if (instance == null) {
            instance = new VendingMachine();
        }

        return instance;
    }

    // Initial Inventory
    private void loadProducts() {

        inventoryService.addProduct(
                ProductFactory.createProduct(ProductType.COKE),5);

        inventoryService.addProduct(
                ProductFactory.createProduct(ProductType.PEPSI),5);

        inventoryService.addProduct(
                ProductFactory.createProduct(ProductType.CHIPS),5);

        inventoryService.addProduct(
                ProductFactory.createProduct(ProductType.BISCUITS),5);

        inventoryService.addProduct(
                ProductFactory.createProduct(ProductType.WATER),5);
    }

    // Display Products
    public void displayProducts() {
        inventoryService.displayProducts();
    }

    // Select Product
    public void selectProduct(ProductType type) {

        if (!inventoryService.isAvailable(type)) {
            state = new OutOfStockState();
        }

        state.selectProduct(this, type);
    }

    // Payment
    public void makePayment(PaymentStrategy paymentStrategy) {
        state.makePayment(this, paymentStrategy);
    }

    // Dispense
    public void dispenseProduct() {
        state.dispenseProduct(this);
    }

    // Cancel
    public void cancelTransaction() {
        state.cancelTransaction(this);
    }

    // Get Selected Product Object
    public Product getSelectedProductObject() {
        return inventoryService.getProduct(selectedProduct);
    }


    public InventoryService getInventoryService() {
        return inventoryService;
    }

    public ProductType getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(ProductType selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

}