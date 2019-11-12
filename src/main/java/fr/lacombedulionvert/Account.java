package fr.lacombedulionvert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Account {

    private static final String STATEMENT_HEADER = "DATE \t\t | AMOUNT \t | BALANCE";

    private int balance;
    private List<Transaction> transactions;

    public Account() {
        balance = 0;
        transactions = new ArrayList<>();
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
        LocalDate date = LocalDate.now();
        transactions.add(Transaction.Builder.aTransaction()
                .withOperation(Operation.DEPOSIT)
                .withDate(date)
                .withAmount(amount)
                .withBalance(balance)
                .build());
    }

    public void withdraw(int amount) {
        balance -= amount;
        LocalDate date = LocalDate.now();
        transactions.add(Transaction.Builder.aTransaction()
                .withOperation(Operation.WITHDRAWAL)
                .withDate(date)
                .withAmount(amount)
                .withBalance(balance)
                .build());
    }

    public String printStatement() {
        String collect = transactions.stream()
                .map(Transaction::toString)
                .collect(Collectors.joining());
        return STATEMENT_HEADER + collect;
    }
}
