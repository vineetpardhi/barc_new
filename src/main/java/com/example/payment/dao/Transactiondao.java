package com.example.payment.dao;

import java.util.ArrayList;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.payment.entity.Account_transaction;
import com.example.payment.entity.Bill;
import com.example.payment.entity.Biller;
import com.example.payment.entity.User;
import com.example.payment.repo.BillRepo;
import com.example.payment.repo.TransactionRepo;
import com.example.payment.repo.BillRepo;


@Repository
public class Transactiondao {
	@Autowired
	private TransactionRepo repo;
	
	@Autowired
	private BillRepo billrepo;
	
	@Autowired
	Billdao billdao;
	
	@Autowired
	Billerdao billerdao;
	
	@Autowired
	UserDao userdao;
	
	@Autowired
	Accountdao accdao;
	
	public String saveTransaction(Account_transaction tran) {
		try {
		System.out.println(tran.getDate());
		repo.save(tran);
		return "Bill is saved with id "+tran.getBill_sequence_id();
		}catch(Exception e) {
			e.printStackTrace();
			return "failed";
		}
		
	}
	
	public List<Account_transaction> getAllTransactions(){
		List<Account_transaction> transactions = (List<Account_transaction>) repo.findAll();
		return transactions;
	}
	
	public List<Account_transaction> getTransactionsByUser(int user_id){
		List<Account_transaction> transactions = (List<Account_transaction>) repo.findAll();
		List<Bill> mybills = billdao.getBillByUserId(user_id);
		List<Account_transaction> result = new ArrayList<Account_transaction>();
		
		for(Account_transaction a : transactions) {
			for(Bill bi : mybills) {
				if(a.getBill_sequence_id() == bi.getBill_sequence_id()) {
					result.add(a);
				}
			}
		}
		
		return result;
	}
	
	public String makePayment(int bill_seq_id) {
		Account_transaction tran = new Account_transaction();
		try {
		Bill bill = billrepo.findById(bill_seq_id).get();	
		int user_acc_no = billerdao.getBillerByConsumerNumber(bill.getConsumer_number());
		int balance = accdao.getAmtForUser(user_acc_no);
		
		if(bill.getStatus() == "PAID") {
			return "Payment already made";
		}
		
		if(balance<bill.getAmount()) {
			return "You don't have enough balance for transaction";
		}
		
		Date today = new Date();
		today.setHours(0);
		today.setHours(0);
		today.setSeconds(0);
		//comnpare dates
//		 //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//		LocalDate date = LocalDate.now();
//		
//		System.out.println(date);
//
//		
//		if(bill.getDatetime().after(date)) {
//
//		}
		
		bill.setStatus("PAID");
		
		
		
		tran.setAmount(balance-bill.getAmount());
		tran.setCredit(0);
		tran.setDebit(1);
		tran.setDate(today);
		tran.setDescription("Payment made to "+bill.getBiller_code() + " amount deducted is "+bill.getAmount()
							+ " current balance is "+ tran.getAmount());
		tran.setBill_sequence_id(bill.getBill_sequence_id());
		tran.setSequence_id(Integer.parseInt(bill.getBill_sequence_id() + "" +user_acc_no));
		String msg = this.saveTransaction(tran);	
		if(msg!="failed") {
		billdao.updateBill(bill.getBill_sequence_id(), bill);
		return "Payment is successful";
		}
		}catch (Exception e) {
			e.printStackTrace();
			//add failed transaction
			return "Problem in Payment";
		}
		
		return "Payment failed";
	}
	
//	public List<Account_transaction> getTransactionsByBiller(int biller_id){
//		List<Account_transaction> transactions = (List<Account_transaction>) repo.findAll();
//		List<Bill> mybills = billdao.getBillByUserId(user_id);
//		List<Account_transaction> result = new ArrayList<Account_transaction>();
//		
//		for(Account_transaction a : transactions) {
//			for(Bill bi : mybills) {
//				if(a.getBill_sequence_id() == bi.getBill_sequence_id()) {
//					result.add(a);
//				}
//			}
//		}
//		
//		return result;
//	}
	
	
	
}
