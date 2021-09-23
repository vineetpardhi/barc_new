package com.example.payment.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.payment.repo.AccountRepo;

import com.example.payment.entity.Accounts;
import com.example.payment.entity.User;


@Repository
public class Accountdao {
	
	@Autowired
	private AccountRepo repo;
	
	@Autowired
	UserDao userdao;
	

	public int getAmtForUser(int user_id) {
		User user = userdao.getUserByLoginId(user_id);
		
		Accounts account = repo.findById(user.getLinkedAccount()).get();
		return account.getCurrent_balance();
	}
	
	

}
