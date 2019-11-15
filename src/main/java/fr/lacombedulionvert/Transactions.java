package fr.lacombedulionvert;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Transactions {

    private static final String DELIMITER = "\n";

    private Map<Transaction, Integer> transactions;

    private Transactions() {
        transactions = new HashMap<>();
    }

    public static Transactions initialize() {
        return new Transactions();
    }

    public void add(Operation operation, int amount) {
        transactions.put(Transaction.of(operation, amount),
                calculateBalance(operation, amount));
    }

    private int calculateBalance(Operation operation, int amount) {
        return operation.applyFunction(amount, getLatestBalance());
    }

    private int getLatestBalance() {
        return transactions.isEmpty() ? 0
                : transactions.values().stream()
                .skip(transactions.values().size() - 1)
                .findFirst()
                .get();
    }

    @Override
    public String toString() {
        return transactions.entrySet()
                .stream()
                .map(e -> e.getKey().toString() + e.getValue())
                .collect(Collectors.joining(DELIMITER));
    }
}
