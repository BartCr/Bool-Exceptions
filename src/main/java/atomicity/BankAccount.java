package atomicity;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

/**
 * Story:
 *
 *
 */
public class BankAccount {

    private static final CurrencyUnit EURO = Monetary.getCurrency("EUR");

    private String name;
    private MonetaryAmount balance;

    public BankAccount(String initialName, double initialBalance) {
        name = initialName;
        balance = createAmount(initialBalance);
    }

    public String toString() {
        return name + ": $" + balance;
    }

    public void deposit(double amount) {
        MonetaryAmount before = this.balance;
        this.balance = this.balance.add(createAmount(amount));

        if (balance.isLessThan(before)) {
            throw new IllegalStateException("Balance shrunk after deposit");
        }
    }

    public void withdraw(double amount) {
        MonetaryAmount before = this.balance;
        balance = balance.subtract(createAmount(amount));

        if (balance.isGreaterThan(before)) {
            throw new IllegalStateException("Balance grew after deposit");
        }
        if (balance.isNegative()) {
            throw new IllegalStateException("Negative balance");
        }
    }

    public MonetaryAmount getBalance() {
        return balance;
    }

    static MonetaryAmount createAmount(double amount) {
        return Monetary.getDefaultAmountFactory()
                       .setNumber(amount)
                       .setCurrency(EURO)
                       .create();
    }
}