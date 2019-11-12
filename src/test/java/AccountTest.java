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
    public void deposit() {
        // Given
        Account account = new Account();

        // When
        account.deposit(500);
        int actualBalance = account.getBalance();

        // Then
        Assertions.assertThat(actualBalance).isEqualTo(500);
    }
}
