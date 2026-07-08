package state;

import machine.VendingMachine;
import payment.PaymentStrategy;

public class PaymentPendingState implements State {

    @Override
    public void selectProduct(VendingMachine machine, model.ProductType productType) {

        System.out.println("Payment already completed. Cannot select another product.");
    }

    @Override
    public void makePayment(VendingMachine machine, PaymentStrategy paymentStrategy) {

        System.out.println("Payment has already been made.");
    }

    @Override
    public void dispenseProduct(VendingMachine machine) {

        System.out.println("Dispensing Product...");

        machine.getInventoryService()
                .reduceStock(machine.getSelectedProduct());

        machine.setState(new DispensingState());

        machine.getState().dispenseProduct(machine);
    }

    @Override
    public void cancelTransaction(VendingMachine machine) {

        System.out.println("Cannot cancel after successful payment.");
    }
}