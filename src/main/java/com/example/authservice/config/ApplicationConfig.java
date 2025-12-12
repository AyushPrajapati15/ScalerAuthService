package com.example.authservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ApplicationConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
//        httpSecurity.csrf().disable();
//        httpSecurity.cors().disable();
        httpSecurity.csrf(csrf -> csrf.disable());
        httpSecurity.cors(cors -> cors.disable());
        httpSecurity.authorizeHttpRequests(
                authorize -> authorize.anyRequest().permitAll()
        );
        return httpSecurity.build();
    }
}
