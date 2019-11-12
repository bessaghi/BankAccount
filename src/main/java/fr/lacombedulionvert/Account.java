package fr.lacombedulionvert;

import java.time.LocalDate;

public class Account {

    private static final String STATEMENT_HEADER = "DATE \t\t | AMOUNT \t | BALANCE";

    private int balance;
    private String statement;

    public Account() {
        balance = 0;
        statement = STATEMENT_HEADER;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
        LocalDate date = LocalDate.now();
        statement += "\n" + date.toString() + " \t | " + amount + " \t | " + balance;
    }

    public void withdraw(int amount) {
        balance -= amount;
        LocalDate date = LocalDate.now();
        statement += "\n" + date.toString() + " \t | -" + amount + " \t | " + balance;
    }

    public String printStatement() {
        return statement;
    }
}
