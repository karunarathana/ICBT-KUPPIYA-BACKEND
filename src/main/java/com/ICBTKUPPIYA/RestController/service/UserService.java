package com.ICBTKUPPIYA.RestController.service;

import com.ICBTKUPPIYA.RestController.entity.UserEntity;
import com.ICBTKUPPIYA.RestController.entity.UserPrinciple;
import com.ICBTKUPPIYA.RestController.repo.UserRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepo userRepo;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public UserService(UserRepo userRepo, AuthenticationManager authenticationManager, JWTService jwtService) {
        this.userRepo = userRepo;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> byUserName = userRepo.findByUserName(username);
        System.out.println(byUserName.isPresent());
        if(!byUserName.isPresent()){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrinciple(byUserName.get());
    }
    public String verifyUser(String userName,String password){
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,password));
        boolean authenticated = authentication.isAuthenticated();
        if (authenticated){
            return jwtService.getToken();
        }
        return "Fail";
    }

}
