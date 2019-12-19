package fr.lacombedulionvert;

import java.time.LocalDate;

class Transaction {
    private static final String SEPARATOR = " \t | ";

    private final Operation operation;
    private final LocalDate date;
    private final int amount;

    Transaction(Operation operation, int amount) {
        this.operation = operation;
        this.amount = amount;
        this.date = LocalDate.now();
    }

    @Override
    public String toString() {
        return date
                + SEPARATOR
                + operation
                + amount
                + SEPARATOR;
    }
}
