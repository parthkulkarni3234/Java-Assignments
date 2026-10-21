class BankAccount {
    int balance = 2000;

    synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " | Current Balance: " + balance);
    }

    synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " | Current Balance: " + balance);
        } else {
            System.out.println("Withdrawal of " + amount + " failed: Insufficient funds");
        }
    }
}

class DepositTask implements Runnable {
    BankAccount account;

    DepositTask(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(400);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class WithdrawTask implements Runnable {
    BankAccount account;

    WithdrawTask(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            account.withdraw(600);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class RunnableBankTransactionDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        Thread t1 = new Thread(new DepositTask(account));
        Thread t2 = new Thread(new WithdrawTask(account));

        t1.start();
        t2.start();
    }
}