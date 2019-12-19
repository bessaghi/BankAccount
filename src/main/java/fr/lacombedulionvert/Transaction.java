package fr.lacombedulionvert;

import java.time.LocalDate;

class Transaction {
    private static final String SEPARATOR = " \t | ";

    private final Operation operation;
    private final int amount;
    private final LocalDate date;

    private Transaction(Operation operation, int amount, LocalDate date) {
        this.operation = operation;
        this.amount = amount;
        this.date = date;
    }

    static Transaction operate(Operation operation, int amount, LocalDate date) {
        return new Transaction(operation, amount, date);
    }

    int calculateBalance(int latestBalance) {
        return operation.calculateCurrentBalance(amount, latestBalance);
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
