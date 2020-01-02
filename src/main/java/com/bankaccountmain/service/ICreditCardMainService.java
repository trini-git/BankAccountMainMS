package com.bankaccountmain.service;

import com.bankaccountmain.model.CreditCardMainModel;

import reactor.core.publisher.Mono;

public interface ICreditCardMainService {

	Mono<CreditCardMainModel> insertCreditCard (CreditCardMainModel creditCardMainModel);
	
	Mono<CreditCardMainModel> updateCreditAmount (CreditCardMainModel creditCardMainModel);
	
	Mono<CreditCardMainModel> findByCreditCardNumber(String creditCardNumber);
}
