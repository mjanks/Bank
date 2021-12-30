package com.company;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String bankName) {
        name = bankName;
        branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName) {
        Branch branch = findBranch(branchName);
        if(branch == null) {
            return branches.add(new Branch(branchName));
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initTransaction) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            return branch.newCustomer(customerName, initTransaction);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            return branch.addCustomerTransaction(customerName, transaction);
        }
        return false;
    }

    private Branch findBranch(String branchName) {
        for(int i=0; i < branches.size(); i++) {
            if(branches.get(i).getName().equals(branchName))
                return branches.get(i);
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean printTransactions) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            ArrayList<Customer> customers = branch.getCustomers();
            if(printTransactions) {
                System.out.print("Customer details for branch " + branch.getName() + "\n");
                for(int i=0; i < customers.size(); i++) {
                    System.out.print("Customer: " + customers.get(i).getName() + "[" + (i+1) + "]\n");
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = customers.get(i).getTransactions();
                    for(int j=0; j < transactions.size(); j++) {
                        System.out.print("[" + (j+1) + "] Amount " + transactions.get(j) + "\n");
                    }
                }
                return true;
            } else {
                System.out.print("Customer details for branch " + branch.getName() + "\n");
                for(int i=0; i < customers.size(); i++) {
                    System.out.print("Customer: " + customers.get(i).getName() + "[" + (i+1) + "]\n");
                }
                return true;
            }
        }
        return false;
    }
}
