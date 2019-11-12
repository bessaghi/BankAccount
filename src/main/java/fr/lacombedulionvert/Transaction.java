package fr.lacombedulionvert;

import java.time.LocalDate;

public class Transaction {
    private final Operation operation;
    private final LocalDate date;
    private final int amount;
    private final int balance;

    public Transaction(Operation operation, LocalDate date, int amount, int balance) {
        this.operation = operation;
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }
}
