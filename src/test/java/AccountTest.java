import fr.lacombedulionvert.Account;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void new_account_has_empty_balance() {
        // Given
        Account account = new Account();

        // When
        int actualBalance = account.getBalance();

        // Then
        Assertions.assertThat(actualBalance).isEqualTo(0);
    }

    @Test
    public void deposit_an_amount_into_an_account_increases_the_balance() {
        // Given
        Account account = new Account();

        // When
        account.deposit(500);
        int actualBalance = account.getBalance();

        // Then
        Assertions.assertThat(actualBalance).isEqualTo(500);
    }

    @Test
    public void deposit_multiple_amounts_into_an_account_increases_the_balance_to_sum_of_all_amounts() {
        // Given
        Account account = new Account();

        // When
        account.deposit(500);
        account.deposit(300);
        account.deposit(200);
        int actualBalance = account.getBalance();

        // Then
        Assertions.assertThat(actualBalance).isEqualTo(1000);
    }
}
