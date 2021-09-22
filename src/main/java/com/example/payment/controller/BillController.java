package com.example.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.payment.entity.Bill;
import com.example.payment.entity.Biller;
import com.example.payment.dao.Billdao;

@RestController
public class BillController {
	
	@Autowired
	Billdao billdao;

	@PostMapping("bill")
	public String storeBill(@RequestBody Bill bill) {
		//User db_user= modelMapper.map(user, User.class);
		String msg = billdao.saveBill(bill);
		return msg;
	}
	
	@GetMapping("bill")
	public List<Bill> getBillererById(@RequestParam int user_id) {
		return billdao.getBillByUserId(user_id);
	}
	
}
