package com.bankaccountmain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankaccountmain.model.CreditCardMainModel;
import com.bankaccountmain.repository.ICreditCardMainRepository;

import reactor.core.publisher.Mono;

@Service
public class CreditCardMainService implements ICreditCardMainService {
	
	@Autowired
	ICreditCardMainRepository iCreditCardMainRepository;

	@Override
	public Mono<CreditCardMainModel> insertCreditCard(CreditCardMainModel creditCardMainModel) {
		
		return iCreditCardMainRepository.save(creditCardMainModel);
	}

	@Override
	public Mono<CreditCardMainModel> updateCreditAmount(CreditCardMainModel creditCardMainModel) {
		
		return iCreditCardMainRepository.findByCreditCardNumber(creditCardMainModel.getCreditCardNumber())
			.flatMap(x -> {
				x.setAvalibleAmount(creditCardMainModel.getAvalibleAmount());
				return iCreditCardMainRepository.save(x);
			});
	}

	@Override
	public Mono<CreditCardMainModel> findByCreditCardNumber(String creditCardNumber) {
		
		return iCreditCardMainRepository.findByCreditCardNumber(creditCardNumber);
	}
	
	

}
