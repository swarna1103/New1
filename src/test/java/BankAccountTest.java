import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * blah blah some modification
 */
public class BankAccountTest {

    @Test
    public void testNewAccountMustHaveAtLeast5() {
        BankAccount account = new BankAccount(5);
        assertEquals(5, account.getBalance());
    }

    @Test
    public void testNewAccountMustHaveAtLeast5_2() {
        BankAccount account = new BankAccount(4);
        assertEquals(5, account.getBalance());
    }

    @Test
    public void testDepositShouldIncreaseBalance() {
        BankAccount account = new BankAccount(5);
        account.deposit(5);
        assertEquals(10, account.getBalance());
    }

    @Test
    public void testWithdrawShouldDecreaseBalance() {
        BankAccount account = new BankAccount(100);
        account.withdraw(10);
        assertEquals(90, account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanBalance() {
        BankAccount account = new BankAccount(100);
        account.withdraw(110);
        assertEquals(100, account.getBalance());
    }

    @Test
    public void testBalanceMustBeAtLeast5_1() {
        BankAccount account = new BankAccount(100);
        account.withdraw(96);
        assertEquals(100, account.getBalance());
    }

    @Test
    public void testBalanceMustBeAtLeast5_2() {
        BankAccount account = new BankAccount(100);
        account.withdraw(95);
        assertEquals(5, account.getBalance());
    }

    @Test
    public void testCanTransferBetweenAccounts() {
        BankAccount source = new BankAccount(100);
        BankAccount dest = new BankAccount(90);

        source.transfer(dest, 40);

        assertEquals(60, source.getBalance());
        assertEquals(130, dest.getBalance());
    }

    @Test
    public void testCanTransferBetweenAccounts_BalanceLimit() {
        BankAccount source = new BankAccount(100);
        BankAccount dest = new BankAccount(90);

        source.transfer(dest, 96);

        assertEquals(100, source.getBalance());
        assertEquals(90, dest.getBalance());
    }
}
