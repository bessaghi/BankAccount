package fr.lacombedulionvert;

import static fr.lacombedulionvert.Transaction.Builder.aTransaction;

class Account {

    private Transactions transactions;
    private BankDate date;

    Account() {
        transactions = new Transactions();
        date = new BankDate();
    }

    void deposit(int amount) {
        addTransaction(Operation.DEPOSIT, amount);
    }

    void withdraw(int amount) {
        addTransaction(Operation.WITHDRAWAL, amount);
    }

    private void addTransaction(Operation operation, int amount) {
        transactions.operate(aTransaction()
                .withOperation(operation)
                .withAmount(amount)
                .withDate(date.now())
                .build()
        );
    }

    String printStatement() {
        return transactions.print();
    }
}
