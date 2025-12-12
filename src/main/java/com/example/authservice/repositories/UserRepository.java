package com.example.authservice.repositories;

import com.example.authservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findById(Long along);
    Optional<User> findByEmail(String email);

    @Override
    User save(User user); //UPSERT = UPDATE + INSERT
}
