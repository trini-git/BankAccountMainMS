package com.bankaccountmain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankaccountmain.model.BankAccountMainModel;
import com.bankaccountmain.model.CreditCardMainModel;
import com.bankaccountmain.service.BankAccountMainService;
import com.bankaccountmain.service.CreditCardMainService;

import reactor.core.publisher.Mono;

@RestController
public class BankAccountMainController {

	@Autowired
	BankAccountMainService bankAccountMainService;
	
	@Autowired
	CreditCardMainService creditCardMainService;
	
	@GetMapping("/find-by/{accountNumber}")
	public Mono<BankAccountMainModel> findByAccountNumber (@PathVariable String accountNumber){
		return bankAccountMainService.findByAccountNumber(accountNumber);		
	}
	
	@PostMapping("/insert")
	public Mono<BankAccountMainModel> insertMain(
	      @RequestBody BankAccountMainModel bankAccountMainModel) {

	    return bankAccountMainService.insertMain(bankAccountMainModel);
	}
	
	@PutMapping("/update-amount")
	public Mono<BankAccountMainModel> updateAmount(
	      @RequestBody BankAccountMainModel bankAccountMainModel) {

	    return bankAccountMainService.updateAmount(bankAccountMainModel);
	}
	
	@GetMapping("/find-credit-by/{creditCardNumber}")
	public Mono<CreditCardMainModel> findByCreditCardNumber (@PathVariable String creditCardNumber){
		return creditCardMainService.findByCreditCardNumber(creditCardNumber);
		
	}
	
	@PostMapping("/insert-credit")
	public Mono<CreditCardMainModel> insertCreditCard(
	      @RequestBody CreditCardMainModel creditCardMainModel) {

	    return creditCardMainService.insertCreditCard(creditCardMainModel);
	}
	
	@PutMapping("/update-credit-amount")
	public Mono<CreditCardMainModel> updateCreditAmount(
	      @RequestBody CreditCardMainModel creditCardMainModel) {

	    return creditCardMainService.updateCreditAmount(creditCardMainModel);
	}
	
	/*from atm microservice*/
	
	@PutMapping("/update-atm-amount-deposite")
	public Mono<BankAccountMainModel> updateAtmAmountDeposite(
	      @RequestBody BankAccountMainModel bankAccountMainModel) {

	    return bankAccountMainService.updateAtmAmountDeposite(bankAccountMainModel);
	}
	
	@PutMapping("/update-atm-amount-retire")
	public Mono<BankAccountMainModel> updateAtmAmountRetire(
	      @RequestBody BankAccountMainModel bankAccountMainModel) {

	    return bankAccountMainService.updateAtmAmountRetire(bankAccountMainModel);
	}
		
}
