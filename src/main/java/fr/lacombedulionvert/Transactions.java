package fr.lacombedulionvert;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        List<String> reversed = transactions.entrySet().stream().map(e -> e.getKey().toString() + e.getValue()).collect(Collectors.toList());
        Collections.reverse(reversed);
        return String.join(DELIMITER, reversed);
    }
}
