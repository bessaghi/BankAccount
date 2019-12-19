package fr.lacombedulionvert;

import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.joining;

class Transactions {

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

    @Override
    public String toString() {
        return transactions.entrySet()
                .stream()
                .map(e -> e.getKey().toString() + e.getValue())
                .collect(joining(DELIMITER));
    }
}
