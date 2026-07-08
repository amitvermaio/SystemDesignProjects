package VendingMachine.models;

public class Slot {

    private Product product;
    private int quantity;

    public Slot(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int qty) {
        quantity += qty;
    }

    public void reduceQuantity(int qty) {
        if (qty <= quantity) {
            quantity -= qty;
        }
    }

    public boolean isAvailable() {
        return quantity > 0;
    }

    @Override
    public String toString() {
        return product + " : " + quantity;
    }
}