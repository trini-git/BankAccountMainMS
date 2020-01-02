package com.bankaccountmain.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.bankaccountmain.model.BankAccountMainModel;

import reactor.core.publisher.Mono;

@Repository
public interface IBankAccountMainRepository extends ReactiveMongoRepository<BankAccountMainModel, String>{
	
	Mono<BankAccountMainModel> findByAccountNumber(String accountNumber);
}
