package fr.lacombedulionvert;

import java.time.LocalDate;

public class Transaction {
    private final Operation operation;
    private final LocalDate date;
    private final int amount;
    private final int balance;

    private Transaction(Operation operation, LocalDate date, int amount, int balance) {
        this.operation = operation;
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "\n"
                + date
                + " \t | "
                + operation
                + amount
                + " \t | "
                + balance;
    }

    public static final class Builder {
        private Operation operation;
        private LocalDate date;
        private int amount;
        private int balance;

        private Builder() {
        }

        public static Builder aTransaction() {
            return new Builder();
        }

        public Builder withOperation(Operation operation) {
            this.operation = operation;
            return this;
        }

        public Builder withDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder withAmount(int amount) {
            this.amount = amount;
            return this;
        }

        public Builder withBalance(int balance) {
            this.balance = balance;
            return this;
        }

        public Transaction build() {
            return new Transaction(operation, date, amount, balance);
        }
    }
}
