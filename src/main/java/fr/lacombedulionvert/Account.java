package fr.lacombedulionvert;

import static fr.lacombedulionvert.Transactions.create;

public class Account {

    private static final String STATEMENT_HEADER = "DATE \t\t | AMOUNT \t | BALANCE\n";

    private Transactions transactions;

    public Account() {
        transactions = create();
    }

    public void deposit(int amount) {
        transactions.add(Operation.DEPOSIT, amount);
    }

    public void withdraw(int amount) {
        transactions.add(Operation.WITHDRAWAL, amount);
    }

    public int getBalance() {
        return transactions.getLatestBalance();
    }

    @Override
    public String toString() {
        return STATEMENT_HEADER + transactions;
    }
}
