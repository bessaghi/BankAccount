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

    static final class Builder {
        private Operation operation;
        private int amount;
        private LocalDate date;

        static Builder aTransaction() {
            return new Builder();
        }

        Builder withOperation(Operation operation) {
            this.operation = operation;
            return this;
        }

        Builder withAmount(int amount) {
            this.amount = amount;
            return this;
        }

        Builder withDate(LocalDate date) {
            this.date = date;
            return this;
        }

        Transaction build() {
            return new Transaction(operation, amount, date);
        }
    }
}
