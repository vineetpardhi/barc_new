package com.example.payment.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.payment.entity.Biller;
import com.example.payment.repo.BillerRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class Billerdao {

	
//	@Autowired
//	ModelMapper modelMapper;
	
	@Autowired
	private BillerRepo repo;
	   private static final Logger logger = LoggerFactory.getLogger(Billerdao.class);

	
	public String saveBill(Biller biller) {
		//System.out.println(bill.getDatetime());
		repo.save(biller);
		return "Biller is saved with id "+biller.getBiller_sequence_id();
	}
	
	public List<Biller> getAllBillers(){
		List<Biller> billers = (List<Biller>) repo.findAll();
		return billers;
	}
	
	public List<Biller> getBillersById(int user_accno) {
		List<Biller> biller = (List<Biller>) repo.findAll();
		List<Biller> result = new ArrayList<Biller>();
		System.out.println("Input User acc no is" + user_accno);
		//logger.warn("Input User acc no is" + user_accno);
		for(Biller b : biller) {
			System.out.println("Given User acc no is"+b.getUser_acc_number());
			//logger.info("Given User acc no is"+b.getUser_acc_number());
			if(b.getUser_acc_number() == user_accno) {
				result.add(b);
			}
		}
		return result;
	}
	
	public String deleteBillerById(int user_accno, int billercode) {
		List<Biller> biller = (List<Biller>) repo.findAll();
		for(Biller b : biller) {
			if(b.getUser_acc_number() == user_accno && b.getBiller_code() == billercode) {
				repo.delete(b);
			}
		}
		return "Biller Deleted"; 
	}
	
	/*public String updateBiller(int id,Bill bill) {s
		Optional<Bill> bill = repo.findById(id);  
		if(bill.isPresent()) {
			.setLogin_ID(id);
			repo.save(user);
			return "User updated"; 
		}else {
			return "User doesn't exist";
		}
	}*/
}