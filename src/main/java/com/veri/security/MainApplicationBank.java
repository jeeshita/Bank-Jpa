package com.veri.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.veri.security.entity.BankAccount;
import com.veri.security.service.IBankAccountService;

@SpringBootApplication
@EnableTransactionManagement
public class MainApplicationBank {
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext applicationcontext=SpringApplication.run(MainApplicationBank.class, args);
		
		IBankAccountService bankaccservice=applicationcontext.getBean(IBankAccountService.class);
		
		BankAccount b1=new BankAccount("12","demo","sreedhar");
		bankaccservice.addAccount(b1);
		BankAccount b2=new BankAccount("22","sreedhar","goof");
		bankaccservice.addAccount(b2);	
		BankAccount b3=new BankAccount("32","dummy","troop");
		bankaccservice.addAccount(b3);
		
		
		BankAccount b=bankaccservice.findByUsername("sreedhar");
		
		System.out.println(b.getHoldername()+"...."+b.getUsername()+"...."+b.getId());
		
		
		for(BankAccount bankacc: bankaccservice.findByHoldername("demo")){
			
			System.out.println("the name of the user"+bankacc.getUsername()+"the id is"+bankacc.getId());
			
		}
		
		bankaccservice.findById("45");
		
		
	}
	
	
	

}
