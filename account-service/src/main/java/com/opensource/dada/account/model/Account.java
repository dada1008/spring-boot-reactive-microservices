package com.opensource.dada.account.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Account {
    @Id
    private String id;
    private String number;
    private String customerId;
    private int amount;
}
