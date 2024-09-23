public class DivisiblePrinter {
    private int number = 1; // Shared number to be printed

    // Synchronized method to ensure only one thread prints at a time
    private synchronized void printDivisible(int divisor, String message) {
        while (number <= 15) {
            if (number % divisor == 0) {
                System.out.println(message + ": " + number);
                number++;
                notifyAll(); // Wake up other waiting threads
            } else {
                try {
                    wait(); // Wait until other threads complete their work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    private synchronized void printNumber1() {
        while (number <= 15) {
            if (number % 2 != 0 && number % 3 != 0 && number % 4 != 0 && number % 5 != 0) {
                System.out.println("Number: " + number);
                number++;
                notifyAll(); // Wake up other waiting threads
            } else {
                try {
                    wait(); // Wait until other threads complete their work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    // Thread to print numbers divisible by 2
    public void printTwo() {
        printDivisible(2, "Divisible by 2");
    }

    // Thread to print numbers divisible by 3
    public void printThree() {
        printDivisible(3, "Divisible by 3");
    }

    // Thread to print numbers divisible by 4
    public void printFour() {
        printDivisible(4, "Divisible by 4");
    }

    // Thread to print numbers divisible by 5
    public void printFive() {
        printDivisible(5, "Divisible by 5");
    }

    // Thread to print numbers not divisible by 2, 3, 4, or 5
    public void printNumber() {
        printNumber1();
    }

    public static void main(String[] args) {
        DivisiblePrinter divisiblePrinter = new DivisiblePrinter();

        Thread t1 = new Thread(divisiblePrinter::printTwo);
        Thread t2 = new Thread(divisiblePrinter::printThree);
        Thread t3 = new Thread(divisiblePrinter::printFour);
        Thread t4 = new Thread(divisiblePrinter::printFive);
        Thread t5 = new Thread(divisiblePrinter::printNumber1);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
