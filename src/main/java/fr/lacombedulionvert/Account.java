package fr.lacombedulionvert;

public class Account {

    private static final String STATEMENT_HEADER = "DATE \t | AMOUNT \t | BALANCE";

    private int balance;

    public Account() {
        balance = 0;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public String printStatement() {
        return STATEMENT_HEADER;
    }
}
