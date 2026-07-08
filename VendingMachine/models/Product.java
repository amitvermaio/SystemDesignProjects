package VendingMachine.models;

public enum Product {
    COKE(40),
    PEPSI(45),
    SPRITE(35),
    FANTA(40),
    MAAZA(50);

    private final int price;

    Product(int price){
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

    public static Product fromString(String name){
        return Product.valueOf(name.trim().toUpperCase());
    }
}