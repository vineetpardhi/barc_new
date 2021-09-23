package com.example.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.payment.entity.Biller;
import com.example.payment.entity.User;
import com.example.payment.dao.Billerdao;

@RestController
public class BillerController {
	
	@Autowired
	Billerdao billerdao;

	@PostMapping("biller")
	public String storeBill(@RequestBody Biller biller) {
		//User db_user= modelMapper.map(user, User.class);
		String msg = billerdao.saveBill(biller);
		return msg;
	}
	
	@GetMapping("biller")
	public List<Biller> getAllBillers() {
		return billerdao.getAllBillers();
	}
	

	@GetMapping("billerById")
	public List<Biller> getBillererById(@RequestParam int user_accno) {
		return billerdao.getBillersById(user_accno);
	}
	
	

	@DeleteMapping("biller")
	public String deleteById(@RequestParam("user_accno") int user_accno,@RequestParam("biller_code") int biller_code) {
		return billerdao.deleteBillerById(user_accno,biller_code);
	}
	
}
