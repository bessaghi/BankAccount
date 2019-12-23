package fr.lacombedulionvert;

class Statement {

    private final Transaction transaction;
    private final int balance;

    Statement(Transaction transaction, int balance) {
        this.transaction = transaction;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return transaction.toString() + balance;
    }
}
