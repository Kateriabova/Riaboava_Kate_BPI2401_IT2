package secondlab;

public class AccountMain {
    public static void main(String[] args) {
        Account account = new Account();
        System.out.println("Начальный баланс: " + account.getBalance());
        account.deposit(1000.99);
        System.out.println("Баланс после пополнения на 1000: " + account.getBalance());
        account.deposit(-500);
        account.withdraw(300);
        System.out.println("Баланс после снятия 300: " + account.getBalance());
        account.withdraw(1000);
        account.withdraw(-200);
    }
}
