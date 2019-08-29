package com.veri.security.service;

import java.util.List;

import com.veri.security.entity.BankAccount;

public interface IBankAccountService {
	
	
	public BankAccount addAccount(BankAccount b);
	
	public BankAccount findByUsername(String username);
	
	public List<BankAccount> findByHoldername(String holdername);
	
	
	public BankAccount findById(String Id);
	

}
