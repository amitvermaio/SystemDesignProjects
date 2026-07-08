package model;

public class Product {

    private ProductType type;
    private String name;
    private double price;

    public Product(ProductType type, String name, double price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    public ProductType getType() {
        return type;
    }
    public void setType(ProductType type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Product{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}