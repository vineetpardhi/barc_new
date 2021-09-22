package com.example.payment.auth.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginRequest {

    @NotBlank
    String login_ID;

    @NotBlank
    @Size(max = 80)
    String password;
}
