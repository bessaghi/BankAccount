package fr.lacombedulionvert;

import java.util.LinkedList;

public class Transactions {

    private static final String DELIMITER = "\n";

    private LinkedList<String> transactions;

    private Transactions() {
        this.transactions = new LinkedList<>();
    }

    public static Transactions create() {
        return new Transactions();
    }

    public void add(Transaction transaction) {
        transactions.addLast(transaction.toString());
    }

    @Override
    public String toString() {
        return String.join(DELIMITER, transactions);
    }
}
