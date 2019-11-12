package fr.lacombedulionvert;

import java.util.LinkedList;
import java.util.stream.Collectors;

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

    @Override
    public String toString() {
        return transactions.stream()
                .map(Transaction::toString)
                .collect(Collectors.joining(DELIMITER));
    }
}
