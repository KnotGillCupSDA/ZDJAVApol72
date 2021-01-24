package com.sda.testingbasics.db;

import java.util.*;

public class CustomerDaoImpl implements CustomerDao {

    private final Map<String, Customer> customers;

    public CustomerDaoImpl() {
        customers = new HashMap<>();
    }

    @Override
    public void add(Customer customer) {
        customers.put(customer.getName().toLowerCase(), customer);
    }

    @Override
    public Customer find(String name) {
        return customers.get(name.toLowerCase());
    }

    @Override
    public List<Customer> getAll() {
        return new ArrayList<>(customers.values());
    }
}
