package com.bankaccountmain.service;

import com.bankaccountmain.model.BankAccountMainModel;

import reactor.core.publisher.Mono;

public interface IBankAccountMainService {
	
	Mono<BankAccountMainModel> insertMain(BankAccountMainModel bankAccountMainModel);
	
	Mono<BankAccountMainModel> updateAmount(BankAccountMainModel bankAccountMainModel);
	
	Mono<BankAccountMainModel> findByAccountNumber(String accountNumber);
	
	/*methods for atm microservice*/
	
	Mono<BankAccountMainModel> updateAtmAmountRetire(BankAccountMainModel bankAccountMainModel);
	Mono<BankAccountMainModel> updateAtmAmountDeposite(BankAccountMainModel bankAccountMainModel);
}
