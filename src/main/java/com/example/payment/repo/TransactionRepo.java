package com.example.payment.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.payment.entity.Account_transaction;

public interface TransactionRepo extends CrudRepository<Account_transaction,Integer> {
	

}
