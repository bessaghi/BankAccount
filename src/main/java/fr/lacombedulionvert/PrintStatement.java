package fr.lacombedulionvert;

import java.util.List;

import static java.lang.String.join;
import static java.util.Collections.reverse;
import static java.util.stream.Collectors.toList;

class PrintStatement {

    private static final String STATEMENT_HEADER = "DATE \t\t | AMOUNT \t | BALANCE\n";
    private static final String DELIMITER = "\n";

    private List<String> statements;

    PrintStatement(List<Statement> statements) {
        this.statements = transform(statements);
    }

    String print() {
        return STATEMENT_HEADER
                + join(DELIMITER, reverseTransactions());
    }

    private List<String> transform(List<Statement> statements) {
        return statements.stream()
                .map(Statement::toString)
                .collect(toList());
    }

    private List<String> reverseTransactions() {
        reverse(statements);
        return statements;
    }

}
