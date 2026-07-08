package VendingMachine.payments;

public interface PaymentStrategy {

    boolean pay(int amount);

}