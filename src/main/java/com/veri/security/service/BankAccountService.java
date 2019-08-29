package com.veri.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.veri.security.AccountNotFoundException;
import com.veri.security.entity.BankAccount;
import com.veri.security.repository.BankAccountRepository;

@Service
@Transactional
public class BankAccountService implements IBankAccountService {

	
	@Autowired
	private BankAccountRepository bankrepository;
	

	public BankAccountRepository getBankrepository() {
		return bankrepository;
	}

	public void setBankrepository(BankAccountRepository bankrepository) {
		this.bankrepository = bankrepository;
	}

	
	@Override
	public BankAccount addAccount(BankAccount b) {
		BankAccount bankac=bankrepository.save(b);
		return bankac;
	}

	@Override
	public BankAccount findByUsername(String username) {
		
		
		return bankrepository.findByUsername(username);
	}

	@Override
	public List<BankAccount> findByHoldername(String holdername) {
		
		return bankrepository.findByHoldername(holdername);
	}

	@Override
	public BankAccount findById(String Id) {
		
		
		Optional<BankAccount> container=bankrepository.findById(Id);
		if(container.isPresent()){
			return container.get();
			
		}
		
		
		throw new AccountNotFoundException("The account you are searching fro does not exist please check the id");
	}

}
