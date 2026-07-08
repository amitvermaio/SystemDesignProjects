package state;

import machine.VendingMachine;
import payment.PaymentStrategy;

public class DispensingState implements State {

    @Override
    public void selectProduct(VendingMachine machine, model.ProductType productType) {

        System.out.println("Machine is dispensing product.");
    }

    @Override
    public void makePayment(VendingMachine machine, PaymentStrategy paymentStrategy) {

        System.out.println("Payment already completed.");
    }

    @Override
    public void dispenseProduct(VendingMachine machine) {

        System.out.println("--------------------------------");
        System.out.println("Please collect your product.");
        System.out.println("Thank you for using Vending Machine.");
        System.out.println("--------------------------------");

        machine.setSelectedProduct(null);

        machine.setState(new IdleState());
    }

    @Override
    public void cancelTransaction(VendingMachine machine) {

        System.out.println("Cannot cancel. Product already dispensed.");
    }
}