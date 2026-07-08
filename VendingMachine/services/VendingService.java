package VendingMachine.services;

import VendingMachine.exceptions.OutOfStockException;
import VendingMachine.models.Order;
import VendingMachine.models.Product;
import VendingMachine.models.VendingMachine;

public class VendingService {

    private final VendingMachine vendingMachine = VendingMachine.getInstance();

    public void buy(Order order) {

        Product product = order.getProduct();

        if (!vendingMachine.getInventoryService().isAvailable(product)) {
            throw new OutOfStockException(product + " is out of stock.");
        }

        boolean success =
                vendingMachine.getPaymentService().pay(order.getTotalAmount());

        if (!success) {
            System.out.println("--------------------------------");
            System.out.println("Payment Failed.");
            System.out.println("Order Cancelled.");
            System.out.println("--------------------------------");
            return;
        }

        vendingMachine.getInventoryService().dispense(product);

        System.out.println("--------------------------------");
        System.out.println("Payment Successful.");
        System.out.println(product + " Dispensed Successfully.");
        System.out.println("Thank You!");
        System.out.println("--------------------------------");
    }
}