package fr.lacombedulionvert;

import java.util.LinkedList;

public class Transactions {

    private static final String STATEMENT_HEADER = "DATE \t\t | AMOUNT \t | BALANCE";
    private static final String DELIMITER = "\n";

    private LinkedList<String> transactions;

    private Transactions() {
        transactions = new LinkedList<>();
        transactions.add(STATEMENT_HEADER);
    }

    public static Transactions create() {
        return new Transactions();
    }

    public void add(Transaction transaction) {
        transactions.addLast(transaction.toString());
    }

    public String printStatement() {
        return String.join(DELIMITER, transactions);
    }
}
