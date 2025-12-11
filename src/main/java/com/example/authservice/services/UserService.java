package com.example.authservice.services;

import com.example.authservice.models.Token;
import com.example.authservice.models.User;

public interface UserService {
    User signUp(String name, String email, String password);

    Token login(String email, String password);

    User validateToken(String tokenValue);
}
