package com.  example.authservice.controllers;

import com.example.authservice.dtos.LoginRequestDto;
import com.example.authservice.dtos.SignUpRequestDto;
import com.example.authservice.dtos.TokenDto;
import com.example.authservice.dtos.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signUp(@RequestBody SignUpRequestDto requestDto){
    return null;
    }

    @PostMapping("/login")
    public TokenDto login(@RequestBody LoginRequestDto requestDto){
        return null;

    }

    @GetMapping("/validate/{tokenValues}")
    public UserDto validateToken(@PathVariable("tokenValue") String tokenValue){
    return null;
    }

}
