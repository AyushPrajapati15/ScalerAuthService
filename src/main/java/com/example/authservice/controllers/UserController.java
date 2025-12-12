package com.  example.authservice.controllers;

import com.example.authservice.dtos.LoginRequestDto;
import com.example.authservice.dtos.SignUpRequestDto;
import com.example.authservice.dtos.TokenDto;
import com.example.authservice.dtos.UserDto;
import com.example.authservice.exceptions.PasswordMismatchException;
import com.example.authservice.models.Token;
import com.example.authservice.models.User;
import com.example.authservice.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    private UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/signup")
    public UserDto signUp(@RequestBody SignUpRequestDto requestDto){
        User user = userService.signUp(requestDto.getName(),
                                       requestDto.getEmail(),
                                       requestDto.getPassword());

    return UserDto.from(user);
    }

    @PostMapping("/login")
    public TokenDto login(@RequestBody LoginRequestDto requestDto) throws PasswordMismatchException {
        Token token = userService.login(
                requestDto.getEmail(),
                requestDto.getPassword());
        return TokenDto.from(token);

    }

    @GetMapping("/validate/{tokenValues}")
    public UserDto validateToken(@PathVariable("tokenValue") String tokenValue){
    return null;
    }

}
