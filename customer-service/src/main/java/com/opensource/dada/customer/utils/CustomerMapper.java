package com.opensource.dada.customer.utils;

import com.opensource.dada.customer.model.Customer;

import java.util.List;


public class CustomerMapper {

    public static Customer map(List<Customer> customers) {
        Customer customer = new Customer();
        for (Customer c : customers) {
            if (c.getAccounts() != null) customer.setAccounts(c.getAccounts());
            if (c.getAge() != 0) customer.setAge(c.getAge());
            if (c.getFirstName() != null) customer.setFirstName(c.getFirstName());
            if (c.getLastName() != null) customer.setFirstName(c.getLastName());
        }
        return customer;
    }

}
