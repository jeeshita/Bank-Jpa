package com.veri.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veri.security.entity.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount,String>{

	BankAccount findByUsername(String username);
	
	List<BankAccount> findByHoldername(String holdername);
}
