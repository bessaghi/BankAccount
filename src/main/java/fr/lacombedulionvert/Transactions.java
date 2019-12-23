package fr.lacombedulionvert;

class Transactions {

    private Printer printer;
    private int latestBalance;

    Transactions() {
        latestBalance = 0;
        printer = new Printer();
    }

    void add(Transaction transaction) {
        latestBalance = transaction.calculateBalance(latestBalance);
        printer.add(transaction, latestBalance);
    }

    @Override
    public String toString() {
        return printer.display();
    }
}
