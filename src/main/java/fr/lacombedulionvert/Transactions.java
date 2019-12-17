package fr.lacombedulionvert;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Transactions {

    private static final String DELIMITER = "\n";

    private Map<Transaction, Integer> transactions;

    private Transactions() {
        transactions = new LinkedHashMap<>();
    }

    public static Transactions initialize() {
        return new Transactions();
    }

    public void add(Operation operation, int amount) {
        transactions.put(Transaction.of(operation, amount),
                getActualBalance(operation, amount));
    }

    private int getActualBalance(Operation operation, int amount) {
        return operation.calculateActualBalance(amount, getLatestBalance());
    }

    private int getLatestBalance() {
        return transactions.values()
                .stream()
                .reduce(0, (a, b) -> b);
    }

    @Override
    public String toString() {
        return transactions.entrySet()
                .stream()
                .map(e -> e.getKey().toString() + e.getValue())
                .collect(Collectors.joining(DELIMITER));
    }
}
