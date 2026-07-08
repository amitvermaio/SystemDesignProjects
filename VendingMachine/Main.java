package VendingMachine;

import java.util.Scanner;

import VendingMachine.models.Order;
import VendingMachine.models.Product;
import VendingMachine.models.VendingMachine;
import VendingMachine.payments.CardPayment;
import VendingMachine.payments.CashPayment;
import VendingMachine.payments.UpiPayment;
import VendingMachine.services.VendingService;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        VendingMachine machine = VendingMachine.getInstance();

        machine.getInventoryService().addProduct(Product.COKE, 5);
        machine.getInventoryService().addProduct(Product.PEPSI, 5);
        machine.getInventoryService().addProduct(Product.SPRITE, 5);
        machine.getInventoryService().addProduct(Product.FANTA, 5);

        machine.getInventoryService().displayInventory();

        System.out.print("\nEnter Product : ");
        Product product = Product.fromString(sc.nextLine());

        Order order = new Order.OrderBuilder()
                .setProduct(product)
                .setQuantity(1)
                .setTotalAmount(product.getPrice())
                .build();

        System.out.println("""
                Select Payment Method
                1. Cash
                2. Card
                3. UPI
                """);

        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> machine.getPaymentService().setPaymentStrategy(new CashPayment());
            case 2 -> machine.getPaymentService().setPaymentStrategy(new CardPayment());
            case 3 -> machine.getPaymentService().setPaymentStrategy(new UpiPayment());
            default -> {
                System.out.println("Invalid Choice");
                return;
            }
        }

        VendingService vendingService = new VendingService();
        vendingService.buy(order);

        sc.close();
    }
}