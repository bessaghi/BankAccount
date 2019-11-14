package fr.lacombedulionvert;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TransactionsTest {

    @Test
    void latest_balance_is_the_balance_calculated_after_the_last_operation() {
        Transactions transactions = Transactions.create();
        transactions.add(Operation.DEPOSIT, 500);
        transactions.add(Operation.DEPOSIT, 500);

        Assertions.assertThat(transactions.getLatestBalance()).isEqualTo(1000);

    }
}