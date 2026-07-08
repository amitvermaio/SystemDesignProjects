package payment;

public class UPIPayment implements PaymentStrategy {

    @Override
    public boolean pay(double amount) {

        System.out.println("\n========== UPI PAYMENT ==========");
        System.out.println("Generating UPI QR...");
        System.out.println("Amount : ₹" + amount);
        System.out.println("Payment Successful via UPI ✅");
        System.out.println("=================================\n");

        return true;
    }
}