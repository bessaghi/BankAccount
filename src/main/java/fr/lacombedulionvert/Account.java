package fr.lacombedulionvert;

class Account {

    private static final String STATEMENT_HEADER = "DATE \t\t | AMOUNT \t | BALANCE\n";

    private Transactions transactions;

    Account() {
        transactions = new Transactions();
    }

    void deposit(int amount) {
        transactions.add(Operation.DEPOSIT, amount);
    }

    void withdraw(int amount) {
        transactions.add(Operation.WITHDRAWAL, amount);
    }

    String printStatement() {
        return STATEMENT_HEADER + transactions;
    }
}
