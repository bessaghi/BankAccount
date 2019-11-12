package fr.lacombedulionvert;

public class Account {

    private int balance = 0;

    public int getBalance() {
        return balance;
    }

    public void deposit(int i) {
        balance = i;
    }
}
