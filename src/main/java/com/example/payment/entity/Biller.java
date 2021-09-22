package com.example.payment.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Biller {
	
	@Id
	int biller_sequence_id;
	
	int biller_code;
	int consumer_number;
	int user_acc_number;
	int auto_pay;   //(0/1)
	int auto_pay_limit;
	public int getBiller_sequence_id() {
		return biller_sequence_id;
	}
	public void setBiller_sequence_id(int biller_sequence_id) {
		this.biller_sequence_id = biller_sequence_id;
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
	public int getUser_acc_number() {
		return user_acc_number;
	}
	public void setUser_acc_number(int user_acc_number) {
		this.user_acc_number = user_acc_number;
	}
	public int getAuto_pay() {
		return auto_pay;
	}
	public void setAuto_pay(int auto_pay) {
		this.auto_pay = auto_pay;
	}
	public int getAuto_pay_limit() {
		return auto_pay_limit;
	}
	public void setAuto_pay_limit(int auto_pay_limit) {
		this.auto_pay_limit = auto_pay_limit;
	}

}
