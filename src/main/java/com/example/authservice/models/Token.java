package com.example.authservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
@Entity(name="tokens")
public class Token extends BaseModel{
    private String value;
    private Date expiryDate;
    @ManyToOne
    private User user;
}
