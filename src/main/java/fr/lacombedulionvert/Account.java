package fr.lacombedulionvert;

import static fr.lacombedulionvert.Transactions.create;

public class Account {

    private static final String STATEMENT_HEADER = "DATE \t\t | AMOUNT \t | BALANCE\n";

    private int balance;
    private Transactions transactions;

    public Account() {
        balance = 0;
        transactions = create();
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
        transactions.add(operation, amount);
    }

    @Override
    public String toString() {
        return STATEMENT_HEADER + transactions;
    }
}
