// Main.java
public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine(2);

        vendingMachine.insertCoin();
        vendingMachine.selectProduct();

        vendingMachine.insertCoin();
        vendingMachine.selectProduct();

        vendingMachine.insertCoin();
        vendingMachine.selectProduct();
    }
}
