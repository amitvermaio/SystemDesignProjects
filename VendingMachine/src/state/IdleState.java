package state;

import machine.VendingMachine;
import model.ProductType;
import payment.PaymentStrategy;

public class IdleState implements State {

    @Override
    public void selectProduct(VendingMachine machine, ProductType productType) {

        System.out.println("Product Selected : " + productType);

        machine.setSelectedProduct(productType);
        machine.setState(new ProductSelectedState());
    }

    @Override
    public void makePayment(VendingMachine machine, PaymentStrategy paymentStrategy) {

        System.out.println("Please select a product first.");
    }

    @Override
    public void dispenseProduct(VendingMachine machine) {

        System.out.println("No product selected.");
    }

    @Override
    public void cancelTransaction(VendingMachine machine) {

        System.out.println("No transaction to cancel.");
    }
}