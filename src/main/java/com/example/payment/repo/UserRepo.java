package com.example.payment.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.payment.entity.User;

public interface UserRepo extends CrudRepository<User, Integer>{

}
