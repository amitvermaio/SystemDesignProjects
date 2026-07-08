package payment;

public class CashPayment implements PaymentStrategy {

    @Override
    public boolean pay(double amount) {

        System.out.println("\n========= CASH PAYMENT =========");
        System.out.println("Please Insert Cash");
        System.out.println("Amount : ₹" + amount);
        System.out.println("Cash Received 💵");
        System.out.println("================================\n");

        return true;
    }
}