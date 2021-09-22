package com.example.payment.entity;

import javax.persistence.Entity;
import javax.persistence.Id;




@Entity
public class User {
	
	@Id
	String login_ID;
	
	String Name;
	String Password;
	String Role;
	int LinkedAccount;
	String SequenceID;
	String RoleID;
	public String getLogin_ID() {
		return login_ID;
	}
	public void setLogin_ID(String login_ID) {
		this.login_ID = login_ID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public int getLinkedAccount() {
		return LinkedAccount;
	}
	public void setLinkedAccount(int linkedAccount) {
		LinkedAccount = linkedAccount;
	}
	public String getSequenceID() {
		return SequenceID;
	}
	public void setSequenceID(String sequenceID) {
		SequenceID = sequenceID;
	}
	public String getRoleID() {
		return RoleID;
	}
	public void setRoleID(String roleID) {
		RoleID = roleID;
	}
	
	
	

}
