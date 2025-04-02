package com.ICBTKUPPIYA.RestController.service;

import com.ICBTKUPPIYA.RestController.entity.UserEntity;
import com.ICBTKUPPIYA.RestController.entity.UserPrinciple;
import com.ICBTKUPPIYA.RestController.repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
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
}
