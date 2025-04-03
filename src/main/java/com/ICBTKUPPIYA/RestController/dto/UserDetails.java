package com.ICBTKUPPIYA.RestController.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserDetails {
    private String userName;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
