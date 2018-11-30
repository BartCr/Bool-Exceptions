package atomicity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BankAccountTest {

    private BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount("BOoL", 100);
    }

    @Test
    void deposit() {
        bankAccount.deposit(50);

        assertThat(bankAccount.getBalance()).isEqualTo(BankAccount.createAmount(150));

        assertThatThrownBy(() -> bankAccount.deposit(-50));

        assertThat(bankAccount.getBalance()).isEqualTo(BankAccount.createAmount(150));
    }

    @Test
    void withdraw() {
        bankAccount.withdraw(50);

        assertThat(bankAccount.getBalance()).isEqualTo(BankAccount.createAmount(50));

        assertThatThrownBy(() -> bankAccount.withdraw(-50));
        assertThatThrownBy(() -> bankAccount.withdraw(200));

        assertThat(bankAccount.getBalance()).isEqualTo(BankAccount.createAmount(50));
    }
}