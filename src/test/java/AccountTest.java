import fr.lacombedulionvert.Account;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class AccountTest {

    private Account account;
    private String date;

    @BeforeEach
    void setUp() {
        account = new Account();
        date = LocalDate.now().toString();
    }

    @Test
    public void new_account_has_empty_balance() {
        // When
        int actualBalance = account.getBalance();

        // Then
        Assertions.assertThat(actualBalance).isEqualTo(0);
    }

    @Test
    public void deposit_an_amount_into_an_account_increases_the_balance() {
        // When
        account.deposit(500);
        int actualBalance = account.getBalance();

        // Then
        Assertions.assertThat(actualBalance).isEqualTo(500);
    }

    @Test
    public void deposit_multiple_amounts_into_an_account_increases_the_balance_to_sum_of_all_amounts() {
       // When
        account.deposit(500);
        account.deposit(300);
        account.deposit(200);
        int actualBalance = account.getBalance();

        // Then
        Assertions.assertThat(actualBalance).isEqualTo(1000);
    }

    @Test
    public void withdraw_an_amount_from_an_account_decreases_the_balance() {
       // When
        account.deposit(500);
        account.withdraw(300);
        int actualBalance = account.getBalance();

        // Then
        Assertions.assertThat(actualBalance).isEqualTo(200);
    }

    @Test
    public void print_statement_for_a_new_account_prints_only_the_header() {
       // When
        String actualStatement = account.toString();

        // Then
        Assertions.assertThat(actualStatement).isEqualTo("DATE \t\t | AMOUNT \t | BALANCE\n");
    }

    @Test
    public void print_statement_after_a_deposit_displays_the_operation_in_the_statement() {
       // When
        account.deposit(500);
        String actualStatement = account.toString();

        // Then
        Assertions.assertThat(actualStatement).isEqualTo("DATE \t\t | AMOUNT \t | BALANCE" +
                "\n" + date + " \t | 500 \t | 500");
    }

    @Test
    public void print_statement_after_multiple_deposits_displays_the_operations_in_the_statement() {
       // When
        account.deposit(500);
        account.deposit(200);
        String actualStatement = account.toString();

        // Then
        Assertions.assertThat(actualStatement).isEqualTo("DATE \t\t | AMOUNT \t | BALANCE" +
                "\n" + date + " \t | 500 \t | 500" +
                "\n" + date + " \t | 200 \t | 700");
    }

    @Test
    public void print_statement_after_a_deposit_and_a_withdrawal_displays_the_operations_in_the_statement() {
       // When
        account.deposit(500);
        account.withdraw(200);
        String actualStatement = account.toString();

        // Then
        Assertions.assertThat(actualStatement).isEqualTo("DATE \t\t | AMOUNT \t | BALANCE" +
                "\n" + date + " \t | 500 \t | 500" +
                "\n" + date + " \t | -200 \t | 300");
    }
}
