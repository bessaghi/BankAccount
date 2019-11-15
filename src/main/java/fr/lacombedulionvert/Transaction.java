package fr.lacombedulionvert;

import java.time.LocalDate;

public class Transaction {
    private static final String SEPARATOR = " \t | ";

    private final Operation operation;
    private final LocalDate date;
    private final int amount;

    private Transaction(Operation operation, int amount) {
        this.operation = operation;
        this.date = LocalDate.now();
        this.amount = amount;
    }

    public static Transaction of(Operation operation, int amount) {
        return new Transaction(operation, amount);
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
