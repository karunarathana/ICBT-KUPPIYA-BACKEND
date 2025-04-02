package com.ICBTKUPPIYA.RestController.Controller;

import com.ICBTKUPPIYA.RestController.service.JWTService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLogin {
    private static final Logger logger = LoggerFactory.getLogger(UserLogin.class);
    private final JWTService jwtService;

    public UserLogin(JWTService jwtService) {
        this.jwtService = jwtService;
    }

    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    public ResponseEntity<String> createAuthUser(){
        String token = jwtService.getToken();
        return new ResponseEntity<>(token, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/register" ,method = RequestMethod.POST)
    public ResponseEntity<String> registerUser(){
        return new ResponseEntity<>("Hello Sandeepa", HttpStatus.OK);
    }

}
