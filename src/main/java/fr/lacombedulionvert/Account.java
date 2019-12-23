package fr.lacombedulionvert;

import static fr.lacombedulionvert.Transaction.Builder.aTransaction;

class Account {

    private TransactionsHistory transactionsHistory;
    private Clock date;

    Account() {
        transactionsHistory = new TransactionsHistory();
        date = new Clock();
    }

    void deposit(int amount) {
        addTransaction(Operation.DEPOSIT, amount);
    }

    void withdraw(int amount) {
        addTransaction(Operation.WITHDRAWAL, amount);
    }

    private void addTransaction(Operation operation, int amount) {
        transactionsHistory.add(aTransaction()
                .withOperation(operation)
                .withAmount(amount)
                .withDate(date.now())
                .build()
        );
    }

    String printStatement() {
        return transactionsHistory.print();
    }
}
