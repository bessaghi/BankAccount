package fr.lacombedulionvert;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;

import static fr.lacombedulionvert.Transaction.operate;

class Account {

    private static final String STATEMENT_HEADER = "DATE \t\t | AMOUNT \t | BALANCE\n";

    private Transactions transactions;
    private Clock clock;

    Account() {
        transactions = new Transactions();
        clock = Clock.system(ZoneId.systemDefault());
    }

    void deposit(int amount) {
        addTransaction(Operation.DEPOSIT, amount);
    }

    void withdraw(int amount) {
        addTransaction(Operation.WITHDRAWAL, amount);
    }

    private void addTransaction(Operation operation, int amount) {
        transactions.add(operate(operation, amount, LocalDate.now(clock)));
    }

    String printStatement() {
        return STATEMENT_HEADER + transactions;
    }
}
