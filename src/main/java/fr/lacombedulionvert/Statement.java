package fr.lacombedulionvert;

class Statement {
    private static final String STATEMENT_HEADER = "DATE \t\t | AMOUNT \t | BALANCE\n";

    private final Account account;

    Statement(Account account) {
        this.account = account;
    }

    String print() {
        return STATEMENT_HEADER + account;
    }
}
