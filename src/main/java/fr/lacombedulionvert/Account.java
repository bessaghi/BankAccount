package fr.lacombedulionvert;

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
        String date = "2019/11/12";
        statement += "\n" + date + " \t | " + amount + " \t | " + balance;
    }

    public void withdraw(int amount) {
        balance -= amount;
        String date = "2019/11/12";
        statement += "\n" + date + " \t | -" + amount + " \t | " + balance;
    }

    public String printStatement() {
        return statement;
    }
}
