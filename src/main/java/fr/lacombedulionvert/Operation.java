package fr.lacombedulionvert;

public enum Operation {
    DEPOSIT(""),
    WITHDRAWAL("-");

    private final String displayCharacter;

    Operation(String displayCharacter) {
        this.displayCharacter = displayCharacter;
    }

    @Override
    public String toString() {
        return displayCharacter;
    }
}
