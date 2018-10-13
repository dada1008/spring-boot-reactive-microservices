package com.opensource.dada.customer.controller;

import com.opensource.dada.customer.model.Account;
import com.opensource.dada.customer.model.Customer;
import com.opensource.dada.customer.repository.CustomerRepository;
import com.opensource.dada.customer.utils.CustomerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/customers")
@Slf4j
public class CustomerController {
    @Autowired
    private CustomerRepository repository;
    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/{id}")
    public Mono<Customer> findById(@PathVariable("id") String id) {
        log.info("findById: id={}", id);
        return repository.findById(id);
    }

    @GetMapping
    public Flux<Customer> findAll() {
        log.info("findAll");
        return repository.findAll();
    }

    @GetMapping("/{id}/with-accounts")
    public Mono<Customer> findByIdWithAccounts(@PathVariable("id") String id) {
        log.info("findByIdWithAccounts: id={}", id);
        Flux<Account> accounts = webClientBuilder.build().get().uri("http://account-service/api/accounts/{customer}", id).retrieve().bodyToFlux(Account.class);
        return accounts
                .collectList()
                .map(a -> new Customer(a))
                .mergeWith(repository.findById(id))
                .collectList()
                .map(CustomerMapper::map);
    }

    @PostMapping
    public Mono<Customer> create(@RequestBody Customer customer) {
        log.info("create: {}", customer);
        return repository.save(customer);
    }
}
