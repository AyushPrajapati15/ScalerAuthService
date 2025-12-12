package com.example.authservice.dtos;

import com.example.authservice.models.Token;
import lombok.Data;

@Data
public class TokenDto {
    private String tokenValue;

    public static TokenDto from(Token token){
        if (token==null){
            return null;
        }
        TokenDto tokenDto= new TokenDto();
        tokenDto.setTokenValue(token.getValue());
        return tokenDto;
    }
}
