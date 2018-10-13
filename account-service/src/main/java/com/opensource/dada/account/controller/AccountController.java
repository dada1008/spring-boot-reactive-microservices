package com.opensource.dada.account.controller;

import com.opensource.dada.account.model.Account;
import com.opensource.dada.account.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/accounts")
@Slf4j
public class AccountController {
    @Autowired
    private AccountRepository repository;

    @GetMapping("/customer/{customerId}")
    public Flux<Account> findByCustomer(@PathVariable("customerId") String customerId) {
        log.info("findByCustomer: customerId={}", customerId);
        return repository.findByCustomerId(customerId);
    }

    @GetMapping
    public Flux<Account> findAll() {
        log.info("findAll");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Account> findById(@PathVariable("id") String id) {
        log.info("findById: id={}", id);
        return repository.findById(id);
    }

    @PostMapping
    public Mono<Account> create(@RequestBody Account account) {
        log.info("create: {}", account);
        return repository.save(account);
    }
}
