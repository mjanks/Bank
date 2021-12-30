package com.company;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String customerName, double initTransaction) {
        name = customerName;
        transactions = new ArrayList<Double>();
        transactions.add(initTransaction);
    }

    public String getName() { return name; }

    public ArrayList<Double> getTransactions() { return transactions; }

    public void addTransaction(double transaction) {
        transactions.add(transaction);
    }
}
