package fr.lacombedulionvert;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.String.join;
import static java.util.Collections.reverse;

class Transactions {

    private static final String STATEMENT_HEADER = "DATE \t\t | AMOUNT \t | BALANCE\n";
    private static final String DELIMITER = "\n";

    private Map<Transaction, Integer> transactions;
    private int latestBalance;

    Transactions() {
        transactions = new LinkedHashMap<>();
        latestBalance = 0;
    }

    void add(Transaction transaction) {
        latestBalance = transaction.calculateBalance(latestBalance);
        transactions.put(transaction, latestBalance);
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

    String print() {
        return STATEMENT_HEADER + join(DELIMITER, reverseTransactions());
    }
}
