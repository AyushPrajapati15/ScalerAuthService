package com.example.authservice.services;

import com.example.authservice.models.Token;
import com.example.authservice.models.User;

public class UserServiceImpl implements UserService{
    @Override
    public User signUp(String name, String email, String password) {
        return null;
    }

    @Override
    public Token login(String email, String password) {
        return null;
    }

    @Override
    public User validateToken(String tokenValue) {
        return null;
    }
}
