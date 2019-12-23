package fr.lacombedulionvert;

import java.util.LinkedHashMap;
import java.util.Map;

class TransactionsHistory {

    private Map<Transaction, Integer> transactions;
    private int latestBalance;

    TransactionsHistory() {
        transactions = new LinkedHashMap<>();
        latestBalance = 0;
    }

    void add(Transaction transaction) {
        latestBalance = transaction.calculateBalance(latestBalance);
        transactions.put(transaction, latestBalance);
    }

    String print() {
        return new PrintTransactions(transactions).print();
    }
}
