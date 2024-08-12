// HasCoinState.java
public class HasCoinState implements State {
    private VendingMachine vendingMachine;

    public HasCoinState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin already inserted.");
    }

    @Override
    public void ejectCoin() {
        System.out.println("Coin returned.");
        vendingMachine.setState(vendingMachine.getNoCoinState());
    }

    @Override
    public void selectProduct() {
        System.out.println("Product selected.");
        vendingMachine.setState(vendingMachine.getDispensingState());
    }

    @Override
    public void dispenseProduct() {
        System.out.println("No product dispensed.");
    }
}
