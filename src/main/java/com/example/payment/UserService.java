package com.example.payment;

import com.example.payment.entity.User;

public interface UserService {
    User getCurrentUser ();
    User getUserWithId (String userId);
}
