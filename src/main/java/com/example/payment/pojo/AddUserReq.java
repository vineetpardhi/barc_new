package com.example.payment.pojo;

import lombok.Data;

@Data
public class AddUserReq {

	int login_ID;
	
	String Name;
	String Password;
	String Role;
	int LinkedAccount;
	String SequenceID;
	String RoleID;
}
