package fr.lacombedulionvert;

class Transaction {
    private static final String SEPARATOR = " \t | ";

    private final Operation operation;
    private final int amount;
    private final String date;

    private Transaction(Operation operation, int amount, String date) {
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
        private String date;

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

        Builder withDate(String date) {
            this.date = date;
            return this;
        }

        Transaction build() {
            return new Transaction(operation, amount, date);
        }
    }
}
