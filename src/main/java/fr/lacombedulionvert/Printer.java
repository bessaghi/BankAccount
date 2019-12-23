package fr.lacombedulionvert;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.join;
import static java.util.Collections.reverse;

class Printer {

    private static final String STATEMENT_HEADER = "DATE \t\t | AMOUNT \t | BALANCE";
    private static final String DELIMITER = "\n";

    private List<String> statements;

    Printer() {
        statements = new ArrayList<>();
    }

    String display() {
        statements.add(STATEMENT_HEADER);
        reverse(statements);
        return join(DELIMITER, statements);
    }

    void add(Transaction transaction, int latestBalance) {
        statements.add(transaction.toString() + latestBalance);
    }
}
