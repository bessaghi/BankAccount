package fr.lacombedulionvert;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.String.join;
import static java.util.Collections.reverse;

class Formatter {

    private static final String DELIMITER = "\n";

    private Map<Transaction, Integer> transactions;

    Formatter(Map<Transaction, Integer> transactions) {
        this.transactions = transactions;
    }

    String print() {
        return join(DELIMITER, reverseTransactions());
    }

    private List<String> reverseTransactions() {
        List<String> transactionsList = transformMapToList();
        reverse(transactionsList);
        return transactionsList;
    }

    private List<String> transformMapToList() {
        return transactions.entrySet()
                .stream()
                .map(e -> e.getKey().toString() + e.getValue())
                .collect(Collectors.toList());
    }
}
