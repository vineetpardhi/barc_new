package com.example.payment.auth.services;

import com.example.payment.auth.interfaces.AuthService;
import com.example.payment.auth.requests.LoginRequest;
import com.example.payment.auth.responses.LoginResponse;
import com.example.payment.auth.utils.JWTUtils;
import com.example.payment.entity.User;

import com.example.payment.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
@Log4j2
@Service
public class AuthServiceImp implements AuthService {


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTUtils jwtUtils;

    @Autowired
    UserService userService;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getLogin_ID(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJWTToken(authentication);

        User currentUser = userService.getCurrentUser();

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwt);
        loginResponse.setUser(currentUser);

        return loginResponse;

    }


}
