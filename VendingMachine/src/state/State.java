package state;

import machine.VendingMachine;
import model.ProductType;
import payment.PaymentStrategy;

public interface State {

    void selectProduct(VendingMachine machine, ProductType productType);

    void makePayment(VendingMachine machine, PaymentStrategy paymentStrategy);

    void dispenseProduct(VendingMachine machine);

    void cancelTransaction(VendingMachine machine);
}