package fr.lacombedulionvert;

public class Account {

    private int balance;

    public Account() {
        balance = 0;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance = amount;
    }
}
