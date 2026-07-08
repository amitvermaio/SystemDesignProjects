package payment;

public class CardPayment implements PaymentStrategy {

    @Override
    public boolean pay(double amount) {

        System.out.println("\n========= CARD PAYMENT =========");
        System.out.println("Insert/Swipe Card");
        System.out.println("Amount : ₹" + amount);
        System.out.println("Processing Card...");
        System.out.println("Payment Successful via Card 💳");
        System.out.println("================================\n");

        return true;
    }
}