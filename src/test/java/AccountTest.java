import fr.lacombedulionvert.Account;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void new_account_has_empty_balance() {
        Account account = new Account();

        Assertions.assertThat(account.getBalance()).isEqualTo(0);
    }
}
