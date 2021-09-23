package com.example.payment.entity;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;




@Entity
public class Bill {
	
	@Id
	int bill_sequence_id;
	
	int biller_code;
	int consumer_number;
	int amount;
	String status;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	Date due_date;
	public int getBill_sequence_id() {
		return bill_sequence_id;
	}
	public void setBill_sequence_id(int bill_sequence_id) {
		this.bill_sequence_id = bill_sequence_id;
	}
	public int getBiller_code() {
		return biller_code;
	}
	public void setBiller_code(int biller_code) {
		this.biller_code = biller_code;
	}
	public int getConsumer_number() {
		return consumer_number;
	}
	public void setConsumer_number(int consumer_number) {
		this.consumer_number = consumer_number;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDatetime() {
		return due_date;
	}
	public void setDatetime(Date due_date) {
		this.due_date = due_date;
	}
}
