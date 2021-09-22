package com.example.payment.dao;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.payment.entity.User;
import com.example.payment.repo.UserRepo;

@Repository
public class UserDao {

	
//	@Autowired
//	ModelMapper modelMapper;
	
	@Autowired
	private UserRepo repo;
	
	public String saveUser(User user) {
		repo.save(user);
		return "User is saved with name "+user.getName();
	}
	
	public List<User> getAllUsers(){
		List<User> users = (List<User>) repo.findAll();
		return users;
	}
	
	public User getUserByLoginId(String id) {
		User usr = repo.findById(id).get();
		return usr;
	}
	
	public String deleteUerById(String id) {
		repo.deleteById(id);
		return "User Deleted"; 
	}
	
	public String updateUser(String id,User user) {
		Optional<User> userOpt = repo.findById(id);
		if(userOpt.isPresent()) {
			user.setLogin_ID(id);
			repo.save(user);
			return "User updated"; 
		}else {
			return "User doesn't exist";
		}
	}
}