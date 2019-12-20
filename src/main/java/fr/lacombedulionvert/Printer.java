package fr.lacombedulionvert;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.join;
import static java.util.Collections.reverse;

class Printer {

    private static final String STATEMENT_HEADER = "DATE \t\t | AMOUNT \t | BALANCE";
    private static final String DELIMITER = "\n";

    private List<String> transactions;

    Printer() {
        transactions = new ArrayList<>();
    }

    String display() {
        transactions.add(STATEMENT_HEADER);
        reverse(transactions);
        return join(DELIMITER, transactions);
    }

    void add(Transaction transaction, int latestBalance) {
        transactions.add(transaction.toString() + latestBalance);
    }
}
