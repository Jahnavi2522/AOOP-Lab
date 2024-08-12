// NoCoinState.java
public class NoCoinState implements State {
    private VendingMachine vendingMachine;

    public NoCoinState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin inserted.");
        vendingMachine.setState(vendingMachine.getHasCoinState());
    }

    @Override
    public void ejectCoin() {
        System.out.println("You haven't inserted a coin.");
    }

    @Override
    public void selectProduct() {
        System.out.println("You need to insert a coin first.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("No coin inserted.");
    }
}
