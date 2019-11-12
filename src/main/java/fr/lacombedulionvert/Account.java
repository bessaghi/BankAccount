package fr.lacombedulionvert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private static final String STATEMENT_HEADER = "DATE \t\t | AMOUNT \t | BALANCE";

    private int balance;
    private String statement;
    private List<Transaction> transactions;

    public Account() {
        balance = 0;
        statement = STATEMENT_HEADER;
        transactions = new ArrayList<>();
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
        LocalDate date = LocalDate.now();
        statement += "\n" + date.toString() + " \t | " + amount + " \t | " + balance;
        transactions.add(new Transaction(Operation.DEPOSIT, date, amount, balance));
    }

    public void withdraw(int amount) {
        balance -= amount;
        LocalDate date = LocalDate.now();
        statement += "\n" + date.toString() + " \t | -" + amount + " \t | " + balance;
        transactions.add(new Transaction(Operation.WITHDRAWAL, date, amount, balance));
    }

    public String printStatement() {
        return statement;
    }
}
