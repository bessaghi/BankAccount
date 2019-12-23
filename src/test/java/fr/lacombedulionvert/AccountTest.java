package fr.lacombedulionvert;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class AccountTest {

    private final static String LOCAL_DATE = "13/12/2019";

    @InjectMocks
    private Account account;

    @Mock
    private BankDate date;

    @BeforeEach
    void setUp() {
        account = new Account();

        initMocks(this);
        when(date.now()).thenReturn(LOCAL_DATE);
    }

    @Test
    void print_statement_for_a_new_account_prints_only_the_header() {
       // When
        String actualStatement = account.printStatement();

        // Then
        assertThat(actualStatement).isEqualTo(
                "DATE \t\t | AMOUNT \t | BALANCE\n"
        );
    }

    @Test
    void print_statement_after_a_deposit_displays_the_operation_in_the_statement_with_balance_equaling_amount() {
       // When
        account.deposit(500);
        String actualStatement = account.printStatement();

        // Then
        assertThat(actualStatement).isEqualTo(
                "DATE \t\t | AMOUNT \t | BALANCE" +
                "\n13/12/2019 \t | +500 \t | 500"
        );
    }

    @Test
    void print_statement_after_multiple_deposits_displays_the_operations_in_the_statement_with_balance_equaling_the_sum_of_all_previous_amounts_deposed() {
       // When
        account.deposit(500);
        account.deposit(200);
        String actualStatement = account.printStatement();

        // Then
        assertThat(actualStatement).isEqualTo(
                "DATE \t\t | AMOUNT \t | BALANCE" +
                "\n13/12/2019 \t | +200 \t | 700" +
                "\n13/12/2019 \t | +500 \t | 500"
        );
    }

    @Test
    void print_statement_after_a_deposit_and_a_withdrawal_displays_the_operations_in_the_statement_with_balance_decreasing_after_withdrawal() {
        // When
        account.deposit(500);
        account.withdraw(200);
        String actualStatement = account.printStatement();

        // Then
        assertThat(actualStatement).isEqualTo(
                "DATE \t\t | AMOUNT \t | BALANCE" +
                "\n13/12/2019 \t | -200 \t | 300" +
                "\n13/12/2019 \t | +500 \t | 500"
        );
    }
}
