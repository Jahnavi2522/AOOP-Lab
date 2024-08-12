// DispensingState.java
public class DispensingState implements State {
    private VendingMachine vendingMachine;

    public DispensingState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Please wait, we're already giving you a product.");
    }

    @Override
    public void ejectCoin() {
        System.out.println("Sorry, you already selected a product.");
    }

    @Override
    public void selectProduct() {
        System.out.println("Dispensing in progress. Please wait.");
    }

    @Override
    public void dispenseProduct() {
        vendingMachine.releaseProduct();
        if (vendingMachine.getProductCount() > 0) {
            vendingMachine.setState(vendingMachine.getNoCoinState());
        } else {
            System.out.println("Oops, out of products!");
            vendingMachine.setState(vendingMachine.getSoldOutState());
        }
    }
}
