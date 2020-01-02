package com.bankaccountmain.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.bankaccountmain.model.CreditCardMainModel;

import reactor.core.publisher.Mono;

@Repository
public interface ICreditCardMainRepository extends ReactiveMongoRepository<CreditCardMainModel, String>{
	
	Mono<CreditCardMainModel> findByCreditCardNumber(String creditCardNumber);
		
}
