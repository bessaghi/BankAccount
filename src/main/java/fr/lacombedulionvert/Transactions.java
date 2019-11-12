package fr.lacombedulionvert;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class Transactions {

    private static final String STATEMENT_HEADER = "DATE \t\t | AMOUNT \t | BALANCE";

    private LinkedList<String> transactions;

    public Transactions() {
        transactions = new LinkedList<>();
        transactions.add(STATEMENT_HEADER);
    }

    public void add(Transaction transaction) {
        transactions.addLast(transaction.toString());
    }

    public String printStatement() {
        return transactions.stream().collect(Collectors.joining());
    }
}
