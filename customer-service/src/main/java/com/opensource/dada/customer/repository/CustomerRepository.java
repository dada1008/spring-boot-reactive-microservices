package com.opensource.dada.customer.repository;

import com.opensource.dada.customer.model.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, String> {

}
