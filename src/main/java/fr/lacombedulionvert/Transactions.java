package fr.lacombedulionvert;

import java.util.ArrayList;
import java.util.List;

class Transactions {

    private List<Statement> statements;
    private int latestBalance;

    Transactions() {
        statements = new ArrayList<>();
        latestBalance = 0;
    }

    void operate(Transaction transaction) {
        latestBalance = transaction.calculateBalance(latestBalance);
        statements.add(new Statement(transaction, latestBalance));
    }

    String print() {
        return new PrintStatement(statements).print();
    }
}
