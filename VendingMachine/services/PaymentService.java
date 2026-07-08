package VendingMachine.services;

import VendingMachine.payments.PaymentStrategy;

public class PaymentService {

    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public boolean pay(int amount) {

        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy not selected.");
        }

        return paymentStrategy.pay(amount);
    }
}