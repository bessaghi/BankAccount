package fr.lacombedulionvert;

import java.util.LinkedList;
import java.util.stream.Collectors;

import static fr.lacombedulionvert.Transaction.Builder.aTransaction;

public class Transactions {

    private static final String DELIMITER = "\n";

    private LinkedList<Transaction> transactions;

    private Transactions() {
        this.transactions = new LinkedList<>();
    }

    public static Transactions create() {
        return new Transactions();
    }

    public void add(Operation operation, int amount) {
        transactions.addLast(aTransaction()
                .withOperation(operation)
                .withAmount(amount)
                .withBalance(calculateBalance(operation, amount))
                .build());
    }

    private int calculateBalance(Operation operation, int amount) {
        return operation.applyFunction(amount, getLatestBalance());
    }

    public int getLatestBalance() {
        return transactions.isEmpty() ? 0 : transactions.getLast().getBalance();
    }

    @Override
    public String toString() {
        return transactions.stream()
                .map(Transaction::toString)
                .collect(Collectors.joining(DELIMITER));
    }
}
