package fr.lacombedulionvert;

import java.util.function.BinaryOperator;

enum Operation {
    DEPOSIT("+", (a, b) -> b + a),
    WITHDRAWAL("-", (a, b) -> b - a);

    private final String displayCharacter;
    private final BinaryOperator<Integer> function;

    Operation(String displayCharacter, BinaryOperator<Integer> function) {
        this.displayCharacter = displayCharacter;
        this.function = function;
    }

    int calculateCurrentBalance(int amount, int previousBalance) {
        return function.apply(amount, previousBalance);
    }

    @Override
    public String toString() {
        return displayCharacter;
    }
}
