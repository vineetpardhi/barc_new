package com.example.payment.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.payment.entity.Bill;
import com.example.payment.entity.Biller;
import com.example.payment.repo.BillRepo;

@Repository
public class Billdao {

	
//	@Autowired
//	ModelMapper modelMapper;
	
	@Autowired
	private BillRepo repo;
	
	@Autowired
	Billerdao billerdao;
	
	
	public String saveBill(Bill bill) {
		System.out.println(bill.getDatetime());
		repo.save(bill);
		return "Bill is saved with id "+bill.getBill_sequence_id();
	}
	
	public List<Bill> getAllBills(){
		List<Bill> bills = (List<Bill>) repo.findAll();
		return bills;
	}
	
	public List<Bill> getBillByUserId(int user_id) {
		List<Biller> mybillers = billerdao.getBillersById(user_id);
		List<Bill> bills = (List<Bill>) repo.findAll();
		
		List<Bill> result = new ArrayList<Bill>();
		
		for(Biller b : mybillers) {
			for(Bill bi : bills) {
				if(b.getConsumer_number() == bi.getConsumer_number()) {
					result.add(bi);
				}
			}
		}
		
		return result;
	}
	
	public String deleteBillById(int id) {
		repo.deleteById(id);
		return "Bill Deleted"; 
	}
	
	/*public String updateBill(int id,Bill bill) {
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