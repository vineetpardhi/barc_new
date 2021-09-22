package com.example.payment.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.payment.entity.Bill;

public interface BillRepo extends CrudRepository<Bill,Integer>{

}
