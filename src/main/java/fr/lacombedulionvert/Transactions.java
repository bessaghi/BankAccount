package fr.lacombedulionvert;

import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.joining;

class Transactions {

    private static final String DELIMITER = "\n";

    private Map<Transaction, Integer> transactions;

    Transactions() {
        transactions = new LinkedHashMap<>();
    }

    void add(Transaction transaction) {
        transactions.put(
                transaction,
                transaction.calculateBalance(getLatestBalance())
        );
    }

    private int getLatestBalance() {
        return transactions.values()
                .stream()
                .reduce(0, (first, second) -> second);
    }

    @Override
    public String toString() {
        return transactions.entrySet()
                .stream()
                .map(e -> e.getKey().toString() + e.getValue())
                .collect(joining(DELIMITER));
    }
}
