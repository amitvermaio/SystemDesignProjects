package factory;

import model.Product;
import model.ProductType;

public class ProductFactory {

    public static Product createProduct(ProductType type) {

        return switch (type) {
            case COKE -> new Product(ProductType.COKE, "Coca Cola", 40);
            case PEPSI -> new Product(ProductType.PEPSI, "Pepsi", 35);
            case CHIPS -> new Product(ProductType.CHIPS, "Lays Chips", 20);
            case BISCUITS -> new Product(ProductType.BISCUITS, "Good Day", 30);
            case WATER -> new Product(ProductType.WATER, "Bisleri", 20);
            default -> throw new IllegalArgumentException("Invalid Product");
        };
    }
}