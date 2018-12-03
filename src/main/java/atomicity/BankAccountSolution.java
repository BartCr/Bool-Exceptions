package atomicity;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;
import java.util.Locale;

public class BankAccountSolution {
    private static final CurrencyUnit EURO = Monetary.getCurrency("EUR");
    public static final MonetaryAmountFormat AMOUNT_FORMAT = MonetaryFormats.getAmountFormat(new Locale("nl", "BE"));

    private String name;
    private MonetaryAmount balance;

    public BankAccountSolution(String initialName, double initialBalance) {
        name = initialName;
        balance = createAmount(initialBalance);
    }

    public String toString() {
        return name + ": $" + balance;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Can't deposit negative amounts: " + amount);
        }
        this.balance = this.balance.add(createAmount(amount));
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Can't withdraw negative amounts: " + amount);
        }
        if (createAmount(amount).isGreaterThan(balance)) {
            throw new IllegalArgumentException("Can't withdraw more money than available: " + amount + " (Balance: " + AMOUNT_FORMAT.format(balance) + ")");
        }
        balance = balance.subtract(createAmount(amount));
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