final class BankAccount {
    final String accountNumber;
    String accountHolder;
    double balance;

    BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    final void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}

public class AccountManager {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("AC10035456", "Parth Kulkarni", 4500000.0);
        account.displayAccountInfo();

    }
}