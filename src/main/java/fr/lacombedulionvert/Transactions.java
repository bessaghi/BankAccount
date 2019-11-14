package fr.lacombedulionvert;

import java.util.LinkedList;

import static fr.lacombedulionvert.Transaction.print;
import static java.lang.String.join;

public class Transactions {

    private static final String DELIMITER = "\n";

    private LinkedList<String> transactions;

    private Transactions() {
        transactions = new LinkedList<>();
    }

    public static Transactions initialize() {
        return new Transactions();
    }

    public void add(Operation operation, int amount) {
        int balance = calculateBalance(operation, amount);
        transactions.addLast(print(operation, amount) + balance);
    }

    private int calculateBalance(Operation operation, int amount) {
        return operation.applyFunction(amount, getLatestBalance());
    }

    private int getLatestBalance() {
        if (transactions.isEmpty()) {
            return 0;
        }
        String[] elements = transactions.getLast().split(" ");
        return Integer.valueOf(elements[elements.length - 1]);
    }

    @Override
    public String toString() {
        return join(DELIMITER, transactions);
    }
}
