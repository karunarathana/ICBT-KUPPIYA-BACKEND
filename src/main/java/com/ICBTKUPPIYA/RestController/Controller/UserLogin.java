package com.ICBTKUPPIYA.RestController.Controller;

import com.ICBTKUPPIYA.RestController.service.JWTService;
import com.ICBTKUPPIYA.RestController.service.UserService;
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
    private final UserService userService;

    public UserLogin(JWTService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    public ResponseEntity<String> createAuthUser(){
        String s = userService.verifyUser("karu", "123");
//        String token = jwtService.getToken();
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/register" ,method = RequestMethod.POST)
    public ResponseEntity<String> registerUser(){
        return new ResponseEntity<>("Hello Sandeepa", HttpStatus.OK);
    }

    @RequestMapping(value = "/student" ,method = RequestMethod.POST)
    public ResponseEntity<String> getAllStudent(){
        return new ResponseEntity<>("Ammat hudu", HttpStatus.OK);
    }

}
