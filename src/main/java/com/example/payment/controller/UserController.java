package com.example.payment.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.payment.dao.UserDao;
import com.example.payment.entity.User;

@RestController
public class UserController {

	
	@Autowired
	UserDao userdao;
	
	
	
	
	@PostMapping("user")
	public String storeUser(@RequestBody User users) {
		//User db_user= modelMapper.map(user, User.class);
		String msg = userdao.saveUser(users);
		return msg;
	}
	
	@GetMapping("user")
	public List<User> getAllUsers() {
		return userdao.getAllUsers();
	}
	
	@GetMapping("user/{id}")
	public User getUserById(@PathVariable int id) {
		return userdao.getUserByLoginId(id);
	}
	
	@DeleteMapping("user/{id}")
	public String deleteById(@PathVariable int id) {
		return userdao.deleteUerById(id);
	}
	
	@PutMapping("user/{id}")
	public String updateUser(@PathVariable int id,@RequestBody User user) {
		return userdao.updateUser(id, user);
	}
}
