package fr.lacombedulionvert;

import static fr.lacombedulionvert.Transaction.operate;

class Account {

    private static final String STATEMENT_HEADER = "DATE \t\t | AMOUNT \t | BALANCE\n";

    private Transactions transactions;

    Account() {
        transactions = new Transactions();
    }

    void deposit(int amount) {
        addTransaction(Operation.DEPOSIT, amount);
    }

    void withdraw(int amount) {
        addTransaction(Operation.WITHDRAWAL, amount);
    }

    private void addTransaction(Operation operation, int amount) {
        transactions.add(operate(operation, amount));
    }

    String printStatement() {
        return STATEMENT_HEADER + transactions;
    }
}
