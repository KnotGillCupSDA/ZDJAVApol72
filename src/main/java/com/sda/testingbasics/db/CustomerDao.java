package com.sda.testingbasics.db;

import java.util.Collection;
import java.util.List;

public interface CustomerDao {

    /**
     * Adds customer to database
     *
     * @param customer to add
     */
    void add(Customer customer);

    /**
     * Finds customer by name
     *
     * @param name used for search, case insensitive
     * @return a Customer with given name if exists or null otherwise
     */
    Customer find(String name);

    /**
     * Gets all customers from the database
     *
     * @return an unsorted collection of customers or an empty list
     */
    List<Customer> getAll();
}
