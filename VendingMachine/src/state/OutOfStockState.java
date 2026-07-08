package state;

import machine.VendingMachine;
import model.ProductType;
import payment.PaymentStrategy;
import exception.OutOfStockException;

public class OutOfStockState implements State {

    @Override
    public void selectProduct(VendingMachine machine, ProductType productType) {
        System.out.println("Selected product is Out Of Stock.");
        machine.setState(new IdleState());
        throw new OutOfStockException("Selected product is Out Of Stock.");
    }

    @Override
    public void makePayment(VendingMachine machine, PaymentStrategy paymentStrategy) {
        System.out.println("Cannot make payment. Product is Out Of Stock.");
    }

    @Override
    public void dispenseProduct(VendingMachine machine) {
        System.out.println("No product to dispense.");
    }

    @Override
    public void cancelTransaction(VendingMachine machine) {
        System.out.println("Returning Machine to Idle State.");

        machine.setSelectedProduct(null);
        machine.setState(new IdleState());
    }
}