package com.example.payment.auth.interfaces;

import com.example.payment.auth.requests.LoginRequest;
import com.example.payment.auth.responses.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);


}
