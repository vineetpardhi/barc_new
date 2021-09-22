package com.example.payment.services;

import com.example.payment.auth.UserPrincipal;
import com.example.payment.entity.User;
import com.example.payment.UserService;
import com.example.payment.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {


    @Autowired
    UserRepo userRepo;

    @Override
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        String userId = userPrincipal.getLogin_ID();
        return getUserWithId(userId);
    }

    @Override
    public User getUserWithId (String userId) {
//        Optional<User> userOptional = userRepo.findById(userId);
//        if(userOptional.isEmpty()){
//            throw new UserNotFoundException();
//        }
//        return userOptional.get();
        return null;
    }
}
