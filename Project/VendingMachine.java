// VendingMachine.java
public class VendingMachine {
    private State noCoinState;
    private State hasCoinState;
    private State dispensingState;

    private State currentState;
    private int productCount;

    public VendingMachine(int productCount) {
        this.productCount = productCount;

        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        dispensingState = new DispensingState(this);

        if (productCount > 0) {
            currentState = noCoinState;
        } else {
            currentState = soldOutState;
        }
    }

    public void insertCoin() {
        currentState.insertCoin();
    }

    public void ejectCoin() {
        currentState.ejectCoin();
    }

    public void selectProduct() {
        currentState.selectProduct();
        currentState.dispenseProduct();
    }

    void setState(State state) {
        currentState = state;
    }

    void releaseProduct() {
        System.out.println("A product is being dispensed...");
        if (productCount > 0) {
            productCount--;
        }
    }

    int getProductCount() {
        return productCount;
    }

    State getNoCoinState() {
        return noCoinState;
    }

    State getHasCoinState() {
        return hasCoinState;
    }

    State getDispensingState() {
        return dispensingState;
    }
}
