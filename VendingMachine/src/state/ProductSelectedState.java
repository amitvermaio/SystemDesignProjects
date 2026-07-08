package state;

import machine.VendingMachine;
import model.Product;
import payment.PaymentStrategy;

public class ProductSelectedState implements State {

    @Override
    public void selectProduct(VendingMachine machine, model.ProductType productType) {

        System.out.println("Product already selected.");
    }

    @Override
    public void makePayment(VendingMachine machine, PaymentStrategy paymentStrategy) {

        Product product = machine.getInventoryService()
                .getProduct(machine.getSelectedProduct());

        if (paymentStrategy.pay(product.getPrice())) {

            machine.setState(new PaymentPendingState());

            System.out.println("Payment Completed.");
        }
    }

    @Override
    public void dispenseProduct(VendingMachine machine) {

        System.out.println("Please complete payment first.");
    }

    @Override
    public void cancelTransaction(VendingMachine machine) {

        System.out.println("Transaction Cancelled.");

        machine.setSelectedProduct(null);
        machine.setState(new IdleState());
    }
}