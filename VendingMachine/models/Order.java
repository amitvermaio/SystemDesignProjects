package VendingMachine.models;

public class Order {

    private final Product product;
    private final int quantity;
    private final int totalAmount;

    private Order(OrderBuilder builder) {
        this.product = builder.product;
        this.quantity = builder.quantity;
        this.totalAmount = builder.totalAmount;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public static class OrderBuilder {

        private Product product;
        private int quantity;
        private int totalAmount;

        public OrderBuilder setProduct(Product product) {
            this.product = product;
            return this;
        }

        public OrderBuilder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public OrderBuilder setTotalAmount(int totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}