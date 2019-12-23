package fr.lacombedulionvert;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.String.join;
import static java.util.Collections.reverse;

class PrintTransactions {

    private static final String STATEMENT_HEADER = "DATE \t\t | AMOUNT \t | BALANCE\n";
    private static final String DELIMITER = "\n";

    private List<String> transactions;

    PrintTransactions(Map<Transaction, Integer> transactions) {
        this.transactions = transformMapToList(transactions);
    }

    String print() {
        return STATEMENT_HEADER + join(DELIMITER, reverseTransactions());
    }

    private List<String> reverseTransactions() {
        reverse(transactions);
        return transactions;
    }

    private List<String> transformMapToList(Map<Transaction, Integer> transactions) {
        return transactions.entrySet()
                .stream()
                .map(e -> e.getKey().toString() + e.getValue())
                .collect(Collectors.toList());
    }
}
