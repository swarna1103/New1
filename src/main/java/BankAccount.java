/**
 * Created by dse on 9/15/2015.
 */
public class BankAccount {
    private int balance;

    private BankAccount() {
        //do smt here
    }

    public BankAccount(int initialAmount) {
        balance = (initialAmount >= 5)  ? initialAmount : 5;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        if (canWithdraw(amount)) {
            balance -= amount;
        }
    }

    public void transfer(BankAccount dest, int amount) {
        if (canWithdraw(amount)) {
            return;
        }
        dest.balance += amount;
        this.balance -= amount;
    }

    public boolean canWithdraw(int amount) {
        return amount + 5 < balance;
    }
}
