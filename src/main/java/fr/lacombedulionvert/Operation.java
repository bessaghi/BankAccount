package fr.lacombedulionvert;

import java.util.function.BinaryOperator;

public enum Operation {
    DEPOSIT("", (a, b) -> b + a),
    WITHDRAWAL("-", (a, b) -> b - a);

    private final String displayCharacter;
    private final BinaryOperator<Integer> function;

    Operation(String displayCharacter, BinaryOperator<Integer> function) {
        this.displayCharacter = displayCharacter;
        this.function = function;
    }

    BinaryOperator<Integer> getFunction() {
        return function;
    }

    @Override
    public String toString() {
        return displayCharacter;
    }
}
