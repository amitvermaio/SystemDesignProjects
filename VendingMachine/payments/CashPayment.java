package VendingMachine.payments;

import java.util.Scanner;

public class CashPayment implements PaymentStrategy {

    @Override
    public boolean pay(int amount) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Amount to Pay : ₹" + amount);
        System.out.print("Payment Successful? (YES/NO): ");

        String status = sc.nextLine();

        return status.equalsIgnoreCase("YES");
    }
}