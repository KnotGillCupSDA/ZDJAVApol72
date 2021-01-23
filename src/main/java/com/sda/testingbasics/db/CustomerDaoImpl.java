package com.sda.testingbasics.db;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
    public Collection<Customer> getAll() {
        return customers.values();
    }
}
