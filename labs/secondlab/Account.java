package secondlab;

public class Account {
    private double balance;

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    
    public void withdraw(double amount) {
        if (balance >= amount && amount > 0) {
            balance -= amount;
        } else {
            System.out.println("Недостаточно средств для снятия.");
        }
    }

    public double getBalance() {
        return balance;
    }
}
