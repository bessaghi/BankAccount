package fr.lacombedulionvert;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.String.join;
import static java.util.Collections.reverse;

class PrintTransactions {

    private static final String STATEMENT_HEADER = "DATE \t\t | AMOUNT \t | BALANCE\n";
    private static final String DELIMITER = "\n";

    String print(Map<Transaction, Integer> transactions) {
        return STATEMENT_HEADER + join(DELIMITER, reverseTransactions(transactions));
    }

    private List<String> reverseTransactions(Map<Transaction, Integer> transactions) {
        List<String> transactionsList = transformMapToList(transactions);
        reverse(transactionsList);
        return transactionsList;
    }

    private List<String> transformMapToList(Map<Transaction, Integer> transactions) {
        return transactions.entrySet()
                .stream()
                .map(e -> e.getKey().toString() + e.getValue())
                .collect(Collectors.toList());
    }
}
