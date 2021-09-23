package com.example.payment.Auth;

import com.example.payment.dao.UserDao;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Log4j2
@Service
public class JwtUserDetailsService implements UserDetailsService {

//	@Autowired
//	RestClient client;

//	Log log = new Log();

	//@Value("${DBusername}")
	String DBUsername;

	//@Value("${password}")
	String DBPassword;


	@Autowired
	UserDao userDao;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Log log = new Log();
//		log.setLogString("Authenticating user...checking if user exists in database...");
//		log.setSender("Authentication Server");
//		client.Logger(log);
		com.example.payment.entity.User user=userDao.getUserByLoginId(Integer.parseInt(username));
		if (user !=null) {
//			log.setLogString("Authenticating user...User Exists. Returning user details...");
//			log.setSender("Authentication Server");
//			client.Logger(log);
			log.info(user.getLogin_ID());

			this.DBPassword=user.getPassword();
			log.info(username);
			log.info(this.DBPassword);
			return new User(username, DBPassword,
					new ArrayList<>());
		} else {
//			log.setLogString("Authenticating user..." + "\n" + "Error: User with given username not found." + username);
//			log.setSender("Authentication Server");
//			client.Logger(log);
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
