package com.example.authservice.services;

import com.example.authservice.exceptions.PasswordMismatchException;
import com.example.authservice.models.Token;
import com.example.authservice.models.User;

public interface UserService {
    User signUp(String name, String email, String password);

    Token login(String email, String password) throws PasswordMismatchException;

    User validateToken(String tokenValue);
}
