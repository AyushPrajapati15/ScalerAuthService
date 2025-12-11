package com.example.authservice.dtos;

import com.example.authservice.models.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private String name;
    private String email;
    private List<Role> roles;

}
