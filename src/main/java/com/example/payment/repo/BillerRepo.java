package com.example.payment.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.payment.entity.Biller;

public interface BillerRepo extends CrudRepository<Biller,Integer>{

}
