package com.example.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.payment.dao.Transactiondao;
import com.example.payment.entity.Account_transaction;
import com.example.payment.entity.User;





@RestController
public class TransactionController {
	
	@Autowired
	 Transactiondao transactiondao;
	
	@GetMapping("payment")
	public String pay(@RequestParam int bill_seq_id) {
		//User db_user= modelMapper.map(user, User.class);
		String msg = transactiondao.makePayment(bill_seq_id);
		return msg;
	}
	
	@GetMapping("transactions")
	public List<Account_transaction> getAllTran(){
		return transactiondao.getAllTransactions();
	}

}
