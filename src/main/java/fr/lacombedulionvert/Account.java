package fr.lacombedulionvert;

import static fr.lacombedulionvert.Transactions.initialize;

public class Account {

    private static final String STATEMENT_HEADER = "DATE \t\t | AMOUNT \t | BALANCE\n";

    private Transactions transactions;

    private Account() {
        transactions = initialize();
    }

    public static Account create() {
        return new Account();
    }

    public void deposit(int amount) {
        transactions.add(Operation.DEPOSIT, amount);
    }

    public void withdraw(int amount) {
        transactions.add(Operation.WITHDRAWAL, amount);
    }

    @Override
    public String toString() {
        return STATEMENT_HEADER + transactions;
    }
}
