package com.example.payment.auth.services;

import com.example.payment.auth.UserPrincipal;
import com.example.payment.entity.User;
import com.example.payment.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepo userRepo;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

//    @Override
//    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
//        Optional<User> user = userRepository.findByEmail(userEmail);
//        if(!user.isPresent()){
//            throw new UsernameNotFoundException(userEmail);
//        }
//        return UserPrincipal.create(user.get());
//    }

    @Transactional
    public UserDetails loadUserById(String id)  {
        Optional<User> user = userRepo.findById(id);
        if(!user.isPresent()){
            throw new UsernameNotFoundException(id);
        }
        return UserPrincipal.create(user.get());
    }


}
