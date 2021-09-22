package com.example.payment.auth.responses;

import com.example.payment.entity.User;
import lombok.Data;

@Data
public class LoginResponse {
    String token;
    User user;
}
