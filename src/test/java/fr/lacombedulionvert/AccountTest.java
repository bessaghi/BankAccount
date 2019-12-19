package fr.lacombedulionvert;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

public class AccountTest {

    private final static LocalDate LOCAL_DATE = LocalDate.of(2019, 12, 13);

    @InjectMocks
    private Account account;

    @Mock
    private Clock clock;

    @BeforeEach
    void setUp() {
        account = new Account();

        MockitoAnnotations.initMocks(this);

        Clock fixedClock = Clock.fixed(LOCAL_DATE.atStartOfDay(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        doReturn(fixedClock.instant()).when(clock).instant();
        doReturn(fixedClock.getZone()).when(clock).getZone();
    }

    @Test
    public void print_statement_for_a_new_account_prints_only_the_header() {
       // When
        String actualStatement = account.printStatement();

        // Then
        assertThat(actualStatement).isEqualTo(
                "DATE \t\t | AMOUNT \t | BALANCE\n"
        );
    }

    @Test
    public void print_statement_after_a_deposit_displays_the_operation_in_the_statement_with_balance_equaling_amount() {
       // When
        account.deposit(500);
        String actualStatement = account.printStatement();

        // Then
        assertThat(actualStatement).isEqualTo(
                "DATE \t\t | AMOUNT \t | BALANCE" +
                "\n2019-12-13 \t | +500 \t | 500"
        );
    }

    @Test
    public void print_statement_after_multiple_deposits_displays_the_operations_in_the_statement_with_balance_equaling_the_sum_of_all_previous_amounts_deposed() {
       // When
        account.deposit(500);
        account.deposit(200);
        String actualStatement = account.printStatement();

        // Then
        assertThat(actualStatement).isEqualTo(
                "DATE \t\t | AMOUNT \t | BALANCE" +
                "\n2019-12-13 \t | +500 \t | 500" +
                "\n2019-12-13 \t | +200 \t | 700"
        );
    }

    @Test
    public void print_statement_after_a_deposit_and_a_withdrawal_displays_the_operations_in_the_statement_with_balance_decreasing_after_withdrawal() {
       // When
        account.deposit(500);
        account.withdraw(200);
        String actualStatement = account.printStatement();

        // Then
        assertThat(actualStatement).isEqualTo(
                "DATE \t\t | AMOUNT \t | BALANCE" +
                "\n2019-12-13 \t | +500 \t | 500" +
                "\n2019-12-13 \t | -200 \t | 300"
        );
    }
}
