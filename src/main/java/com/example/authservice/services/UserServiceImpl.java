package com.example.authservice.services;

import com.example.authservice.exceptions.PasswordMismatchException;
import com.example.authservice.models.Token;
import com.example.authservice.models.User;
import com.example.authservice.repositories.TokenRepositoy;
import com.example.authservice.repositories.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private TokenRepositoy tokenRepositoy;

    public UserServiceImpl(UserRepository userRepository,
                           BCryptPasswordEncoder passwordEncoder,
                           TokenRepositoy tokenRepositoy) {
        this.userRepository=userRepository;
        this.bCryptPasswordEncoder=passwordEncoder;
        this.tokenRepositoy=tokenRepositoy;
    }

    @Override
    public User signUp(String name, String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isPresent()){
            //IF USER IS PRESENT REDIRECT TO THE LOGIN PAGE
            return optionalUser.get();
        }
        User user= new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(bCryptPasswordEncoder.encode(password));

        return userRepository.save(user);

    }

    @Override
    public Token login(String email, String password) throws PasswordMismatchException {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isEmpty()){
            //REDIRECT TO THE SIGNUP PAGE
            return null;
        }
        User user =optionalUser.get();
        if (!bCryptPasswordEncoder.matches(password, user.getPassword())){
            //PASSWORD MISMATCH
            throw  new PasswordMismatchException("Invalid Password");

        }
//        Date expiryDate = Date.from(Instant.now().plus(30, ChronoUnit.DAYS));
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        Date expiryDate = calendar.getTime();

        Token token = new Token();
        token.setUser(user);
        token.setValue(RandomStringUtils.randomAlphanumeric(128));
        token.setExpiryDate(expiryDate);
        return tokenRepositoy.save(token);
    }

    @Override
    public User validateToken(String tokenValue) {
        return null;
    }
}
