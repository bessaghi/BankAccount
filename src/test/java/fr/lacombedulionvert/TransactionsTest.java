package fr.lacombedulionvert;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static fr.lacombedulionvert.Transaction.Builder.aTransaction;

class TransactionsTest {

    @Test
    void name() {
        Transactions transactions = Transactions.create();
        transactions.add(aTransaction()
                .withOperation(Operation.DEPOSIT)
                .withAmount(500)
                .withBalance(0)
                .build());

        Assertions.assertThat(transactions.getLatestBalance()).isEqualTo(500);

    }
}