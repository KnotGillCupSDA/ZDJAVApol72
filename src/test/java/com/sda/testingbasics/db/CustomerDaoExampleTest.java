package com.sda.testingbasics.db;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

class CustomerDaoExampleTest {

    @Test
    void thatWeCanAddCustomer() {
        CustomerDao dao = new CustomerDaoImpl();
        String expectedName = "Tomek";
        Customer tomek = new Customer(expectedName, "wozdev@gmail.com");

        dao.add(tomek);

        List<Customer> all = dao.getAll();

        /*Assertions.assertNotNull(all);
        Assertions.assertFalse(all.isEmpty());
        Assertions.assertEquals(1, all.size());

        Customer retrievedCustomer = all.iterator().next();
        Assertions.assertNotNull(retrievedCustomer);

        String name = retrievedCustomer.getName();
        Assertions.assertEquals(expectedName, name);*/

        Assertions.assertThat(all)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1)
                .containsOnly(tomek);

        /* without using .equals()
        Assertions.assertThat(all)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1)
                .element(0)
                .extracting(Customer::getName)
                .isEqualTo(expectedName);*/

    }
}