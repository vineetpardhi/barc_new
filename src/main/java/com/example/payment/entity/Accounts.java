package com.example.payment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Accounts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int account_number;
	
	int sequenceid;
	String first_name;
	String middle_name;
	String last_name;
	String email_id;
	int current_balance;
	int contact_number;
	public int getAccount_number() {
		return account_number;
	}
	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}
	public int getSequenceid() {
		return sequenceid;
	}
	public void setSequenceid(int sequenceid) {
		this.sequenceid = sequenceid;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getMiddle_name() {
		return middle_name;
	}
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public int getCurrent_balance() {
		return current_balance;
	}
	public void setCurrent_balance(int current_balance) {
		this.current_balance = current_balance;
	}
	public int getContact_number() {
		return contact_number;
	}
	public void setContact_number(int contact_number) {
		this.contact_number = contact_number;
	}
	
	
	
}
