package com.example.payment.dao;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.payment.entity.Bill;
import com.example.payment.repo.BillRepo;

@Repository
public class Billdao {

	
//	@Autowired
//	ModelMapper modelMapper;
	
	@Autowired
	private BillRepo repo;
	
	public String saveBill(Bill bill) {
		System.out.println(bill.getDatetime());
		repo.save(bill);
		return "Bill is saved with id "+bill.getBill_sequence_id();
	}
	
	public List<Bill> getAllBills(){
		List<Bill> bills = (List<Bill>) repo.findAll();
		return bills;
	}
	
	public Bill getBillById(int id) {
		Bill bill = repo.findById(id).get();
		return bill;
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