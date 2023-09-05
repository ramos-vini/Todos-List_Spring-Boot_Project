package com.example.demo.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String username, String password){

        boolean isValidUsername = username.equalsIgnoreCase("vini");
        boolean isValidPassword = password.equals("123");

        return (isValidUsername && isValidPassword);
    }
}
