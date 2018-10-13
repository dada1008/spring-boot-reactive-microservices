package com.opensource.dada.customer.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@Document
public class Customer {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private int age;
    @Transient
    private List<Account> accounts;

    public Customer(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Customer(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
