package com.bankaccountmain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankaccountmain.model.BankAccountMainModel;
import com.bankaccountmain.repository.IBankAccountMainRepository;

import reactor.core.publisher.Mono;

@Service
public class BankAccountMainService implements IBankAccountMainService {
	
	@Autowired
	IBankAccountMainRepository iBankAccountMainRepository;
		
	@Override
	public Mono<BankAccountMainModel> insertMain(BankAccountMainModel bankAccountMainModel) {
		
		return iBankAccountMainRepository.save(bankAccountMainModel);
	}

	@Override
	public Mono<BankAccountMainModel> updateAmount(BankAccountMainModel bankAccountMainModel) {
		
		return iBankAccountMainRepository.findByAccountNumber(bankAccountMainModel.getAccountNumber())
			.flatMap(x -> {
				x.setCurrentAmount(bankAccountMainModel.getCurrentAmount());
				x.setNumberOfMovement(bankAccountMainModel.getNumberOfMovement());
				return iBankAccountMainRepository.save(x);
			});
	}

	@Override
	public Mono<BankAccountMainModel> findByAccountNumber(String accountNumber) {
		
		return iBankAccountMainRepository.findByAccountNumber(accountNumber);
	}

	@Override
	public Mono<BankAccountMainModel> updateAtmAmountRetire(BankAccountMainModel bankAccountMainModel) {
		
		return iBankAccountMainRepository.findByAccountNumber(bankAccountMainModel.getAccountNumber())
			.flatMap(a -> {
				a.setCurrentAmount(bankAccountMainModel.getCurrentAmount());
				return iBankAccountMainRepository.save(a);
			});
	}

	@Override
	public Mono<BankAccountMainModel> updateAtmAmountDeposite(BankAccountMainModel bankAccountMainModel) {
		
		return iBankAccountMainRepository.findByAccountNumber(bankAccountMainModel.getAccountNumber())
				.flatMap(a -> {
					a.setCurrentAmount(bankAccountMainModel.getCurrentAmount());
					return iBankAccountMainRepository.save(a);
				});
	}

}
