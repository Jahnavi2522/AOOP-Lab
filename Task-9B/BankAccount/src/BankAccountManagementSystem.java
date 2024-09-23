class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Synchronized deposit method
    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited: $" + amount + " | New balance: $" + balance);
        }
    }

    // Synchronized withdraw method
    public synchronized void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew: $" + amount + " | New balance: $" + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " attempted to withdraw $" + amount + " but insufficient balance.");
        }
    }

    // Synchronized method to check balance
    public synchronized double getBalance() {
        return balance;
    }
}

class BankAccountUser implements Runnable {
    private final BankAccount account;

    public BankAccountUser(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        // Randomly perform deposit or withdrawal
        for (int i = 0; i < 5; i++) {
            double amount = Math.random() * 100; // Random amount between 0 and 100
            if (Math.random() > 0.5) {
                account.deposit(amount);
            } else {
                account.withdraw(amount);
            }

            // Pause briefly to simulate concurrent access
            try {
                Thread.sleep((int) (Math.random() * 500));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class BankAccountManagementSystem {
    public static void main(String[] args) {
        BankAccount sharedAccount = new BankAccount(500.0); // Initial balance is $500

        // Creating users that will perform transactions concurrently
        Thread user1 = new Thread(new BankAccountUser(sharedAccount), "User 1");
        Thread user2 = new Thread(new BankAccountUser(sharedAccount), "User 2");
        Thread user3 = new Thread(new BankAccountUser(sharedAccount), "User 3");

        // Start the threads
        user1.start();
        user2.start();
        user3.start();

        // Wait for all threads to finish
        try {
            user1.join();
            user2.join();
            user3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Final balance
        System.out.println("Final balance: $" + sharedAccount.getBalance());
    }
}
