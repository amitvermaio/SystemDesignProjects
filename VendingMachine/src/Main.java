import machine.VendingMachine;
import model.ProductType;
import payment.CardPayment;
import payment.CashPayment;
import payment.PaymentStrategy;
import payment.UPIPayment;
import exception.OutOfStockException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        VendingMachine vendingMachine = VendingMachine.getInstance();

        System.out.println("=================================");
        System.out.println("     VENDING MACHINE SYSTEM");
        System.out.println("=================================");

        boolean running = true;

        while (running) {

            vendingMachine.displayProducts();

            System.out.println("\nSelect Product");

            System.out.println("1. Coke");
            System.out.println("2. Pepsi");
            System.out.println("3. Chips");
            System.out.println("4. Biscuits");
            System.out.println("5. Water");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();

            if (choice == 0) {
                running = false;
                System.out.println("Thank You!");
                break;
            }

            ProductType selectedProduct = null;

            switch (choice) {
                case 1:
                    selectedProduct = ProductType.COKE;
                    break;
                case 2:
                    selectedProduct = ProductType.PEPSI;
                    break;
                case 3:
                    selectedProduct = ProductType.CHIPS;
                    break;
                case 4:
                    selectedProduct = ProductType.BISCUITS;
                    break;
                case 5:
                    selectedProduct = ProductType.WATER;
                    break;
                default:
                    System.out.println("Invalid Choice");
                    continue;
            }

            try {
                vendingMachine.selectProduct(selectedProduct);
            } catch (OutOfStockException e) {
                System.out.println("\n---------------------------------\n");
                continue;
            }

            System.out.println("\nChoose Payment Method");

            System.out.println("1. UPI");
            System.out.println("2. Card");
            System.out.println("3. Cash");

            int paymentChoice = scanner.nextInt();

            PaymentStrategy paymentStrategy;

            switch (paymentChoice) {

                case 1:
                    paymentStrategy = new UPIPayment();
                    break;

                case 2:
                    paymentStrategy = new CardPayment();
                    break;

                case 3:
                    paymentStrategy = new CashPayment();
                    break;

                default:
                    System.out.println("Invalid Payment Method");
                    continue;
            }

            vendingMachine.makePayment(paymentStrategy);

            vendingMachine.dispenseProduct();

            System.out.println("\nUpdated Inventory");

            vendingMachine.displayProducts();

            System.out.println("\n---------------------------------\n");
        }

        scanner.close();
    }
}