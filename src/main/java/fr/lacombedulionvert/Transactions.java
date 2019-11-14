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

    public void add(Transaction transaction) {
        transactions.addLast(transaction);
    }

    public void add(Operation operation, int amount) {
        transactions.addLast(aTransaction()
                .withOperation(operation)
                .withAmount(amount)
                .withBalance(calculateBalance(operation, amount))
                .build());
    }

    private Integer calculateBalance(Operation operation, int amount) {
        return operation.getFunction().apply(amount, getLatestBalance());
    }

    @Override
    public String toString() {
        return transactions.stream()
                .map(Transaction::toString)
                .collect(Collectors.joining(DELIMITER));
    }

    public int getLatestBalance() {
        return transactions.isEmpty() ? 0 : transactions.getLast().getBalance();
    }
}
