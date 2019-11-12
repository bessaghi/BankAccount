package fr.lacombedulionvert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
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
        transactions.add(operate(amount, Operation.DEPOSIT, a -> balance = balance + a));
    }

    public void withdraw(int amount) {
        transactions.add(operate(amount, Operation.WITHDRAWAL, a -> balance = balance - a));
    }

    private Transaction operate(int amount, Operation operation, Consumer<Integer> function) {
        function.accept(amount);
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
