package com.example.authservice.repositories;

import com.example.authservice.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepositoy extends JpaRepository<Token,Long> {
    @Override
    Optional<Token> findById(Long aLong);

    @Override
    Token save(Token token);
}
