package fr.lacombedulionvert;

import java.util.LinkedHashMap;
import java.util.Map;

import static java.lang.String.join;

class Transactions {

    private Map<Transaction, Integer> transactions;
    private int latestBalance;

    Transactions() {
        latestBalance = 0;
        transactions = new LinkedHashMap<>();
    }

    void add(Transaction transaction) {
        latestBalance = transaction.calculateBalance(latestBalance);
        transactions.put(transaction, latestBalance);
    }

    @Override
    public String toString() {
        return new Formatter(transactions).print();
    }
}
