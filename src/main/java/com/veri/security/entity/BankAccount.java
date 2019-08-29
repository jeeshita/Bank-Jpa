package com.veri.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankAccount<BankAccountRepository> {
	
	
	@Id
	private String id;
	private String holdername;
	
	
	@Column(unique=true)
	private String username;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHoldername() {
		return holdername;
	}
	public void setHoldername(String holdername) {
		this.holdername = holdername;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public BankAccount(String id, String holdername, String username) {
		super();
		this.id = id;
		this.holdername = holdername;
		this.username = username;
	}
	
	
	public BankAccount() {
		
	}
	
	
	
	

}
