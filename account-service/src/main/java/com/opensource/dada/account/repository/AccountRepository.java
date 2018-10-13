package com.opensource.dada.account.repository;

import com.opensource.dada.account.model.Account;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

public interface AccountRepository extends ReactiveCrudRepository<Account, String> {

    Flux<Account> findByCustomerId(String customerId);

}
