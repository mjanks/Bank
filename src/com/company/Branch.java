package com.company;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String branchName) {
        name = branchName;
        customers = new ArrayList<Customer>();
    }

    public String getName() { return name; }

    public ArrayList<Customer> getCustomers() { return customers; }

    public boolean newCustomer(String customerName, double initTransaction) {
        Customer customer = findCustomer(customerName);
        if(customer == null) {
            return customers.add(new Customer(customerName, initTransaction));
        }
        return false;
    }

    public boolean addCustomerTransaction(String customerName, double transaction) {
        Customer customer = findCustomer(customerName);
        if(customer != null) {
            customer.addTransaction(transaction);
            return true;
        }
        return false;
    }

    private Customer findCustomer(String customerName) {
        for(Customer customer : customers) {
            if(customer.getName() == customerName) {
                return customer;
            }
        }
        return null;
    }
}
