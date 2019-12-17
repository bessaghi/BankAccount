package fr.lacombedulionvert;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class AccountTest {

    private Account account;
    private LocalDate date;

    @BeforeEach
    void setUp() {
        account = Account.create();
        date = LocalDate.now();
    }

    @Test
    public void print_statement_for_a_new_account_prints_only_the_header() {
       // When
        String actualStatement = account.toString();

        // Then
        Assertions.assertThat(actualStatement).isEqualTo("DATE \t\t | AMOUNT \t | BALANCE\n");
    }

    @Test
    public void print_statement_after_a_deposit_displays_the_operation_in_the_statement_with_balance_equaling_amount() {
       // When
        account.deposit(500);
        String actualStatement = account.toString();

        // Then
        Assertions.assertThat(actualStatement).isEqualTo("DATE \t\t | AMOUNT \t | BALANCE" +
                "\n" + date + " \t | +500 \t | 500");
    }

    @Test
    public void print_statement_after_multiple_deposits_displays_the_operations_in_the_statement_with_balance_equaling_the_sum_of_all_previous_amounts_deposed() {
       // When
        account.deposit(500);
        account.deposit(200);
        String actualStatement = account.toString();

        // Then
        Assertions.assertThat(actualStatement).isEqualTo("DATE \t\t | AMOUNT \t | BALANCE" +
                "\n" + date + " \t | +500 \t | 500" +
                "\n" + date + " \t | +200 \t | 700");
    }

    @Test
    public void print_statement_after_a_deposit_and_a_withdrawal_displays_the_operations_in_the_statement_with_balance_decreasing_after_withdrawal() {
       // When
        account.deposit(500);
        account.withdraw(200);
        String actualStatement = account.toString();

        // Then
        Assertions.assertThat(actualStatement).isEqualTo("DATE \t\t | AMOUNT \t | BALANCE" +
                "\n" + date + " \t | +500 \t | 500" +
                "\n" + date + " \t | -200 \t | 300");
    }
}
