package fr.lacombedulionvert;

import static fr.lacombedulionvert.Transaction.Builder.aTransaction;

class Account {

    private Transactions transactions;
    private Date date;

    Account() {
        transactions = new Transactions();
        date = new Date();
    }

    void deposit(int amount) {
        addTransaction(Operation.DEPOSIT, amount);
    }

    void withdraw(int amount) {
        addTransaction(Operation.WITHDRAWAL, amount);
    }

    private void addTransaction(Operation operation, int amount) {
        transactions.add(aTransaction()
                .withOperation(operation)
                .withAmount(amount)
                .withDate(date.now())
                .build()
        );
    }

    @Override
    public String toString() {
        return transactions.toString();
    }
}
