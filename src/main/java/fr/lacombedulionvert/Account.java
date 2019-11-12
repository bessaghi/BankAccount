package fr.lacombedulionvert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static fr.lacombedulionvert.Transaction.Builder.aTransaction;

public class Account {

    private static final String STATEMENT_HEADER = "DATE \t\t | AMOUNT \t | BALANCE";

    private int balance;
    private List<Transaction> transactions;
    private Transactions transactions2;

    public Account() {
        balance = 0;
        transactions = new ArrayList<>();
        transactions2 = new Transactions();
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
        transactions.add(operate(amount, Operation.DEPOSIT));
    }

    public void withdraw(int amount) {
        balance -= amount;
        transactions.add(operate(amount, Operation.WITHDRAWAL));
    }

    private Transaction operate(int amount, Operation operation) {
        return aTransaction()
                .withOperation(operation)
                .withDate(LocalDate.now())
                .withAmount(amount)
                .withBalance(balance)
                .build();
    }

    public String printStatement() {
        String collect = transactions.stream()
                .map(Transaction::toString)
                .collect(Collectors.joining());
        return STATEMENT_HEADER + collect;
    }
}
