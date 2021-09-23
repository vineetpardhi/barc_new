package com.example.payment.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Account_transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int transaction_reference;
	
	int sequence_id;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	Date date;
	
	int amount;
	int credit;  //0 or 1
	int debit; //0 or 1
	String description;
	int bill_sequence_id;
	
	public int getTransaction_reference() {
		return transaction_reference;
	}
	public void setTransaction_reference(int transaction_reference) {
		this.transaction_reference = transaction_reference;
	}
	
	public int getSequence_id() {
		return sequence_id;
	}
	public void setSequence_id(int sequence_id) {
		this.sequence_id = sequence_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public int getDebit() {
		return debit;
	}
	public void setDebit(int debit) {
		this.debit = debit;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getBill_sequence_id() {
		return bill_sequence_id;
	}
	public void setBill_sequence_id(int bill_sequence_id) {
		this.bill_sequence_id = bill_sequence_id;
	}

}
