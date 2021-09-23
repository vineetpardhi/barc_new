package com.example.payment.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.payment.entity.Accounts;

public interface AccountRepo extends CrudRepository<Accounts,Integer> {

}
