package fr.lacombedulionvert;

import java.time.LocalDate;

import static fr.lacombedulionvert.Transaction.Builder.aTransaction;

public class Account {

    private static final String STATEMENT_HEADER = "DATE \t\t | AMOUNT \t | BALANCE";

    private int balance;
    private Transactions transactions;

    public Account() {
        balance = 0;
        transactions = new Transactions();
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        addTransaction(amount, Operation.DEPOSIT);
    }

    public void withdraw(int amount) {
        addTransaction(amount, Operation.WITHDRAWAL);
    }

    private void addTransaction(int amount, Operation operation) {
        balance = operation.getFunction().apply(amount, balance);
        transactions.add(aTransaction()
                .withOperation(operation)
                .withDate(LocalDate.now())
                .withAmount(amount)
                .withBalance(balance)
                .build());
    }

    public String printStatement() {
        return transactions.printStatement();
    }
}
