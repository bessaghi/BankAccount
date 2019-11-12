package fr.lacombedulionvert;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class Transactions {

    private static final String STATEMENT_HEADER = "DATE \t\t | AMOUNT \t | BALANCE";

    private LinkedList<Transaction> transactions;

    public Transactions() {
        transactions = new LinkedList<>();
    }

    public void add(Transaction transaction) {
        transactions.addLast(transaction);
    }

    public String printStatement() {
        String collect = transactions.stream()
                .map(Transaction::toString)
                .collect(Collectors.joining());
        return STATEMENT_HEADER + collect;
    }
}
