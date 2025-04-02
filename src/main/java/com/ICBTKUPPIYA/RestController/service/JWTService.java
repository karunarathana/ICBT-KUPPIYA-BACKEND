package com.ICBTKUPPIYA.RestController.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JWTService {
    private final SecretKey secretKey;

    public JWTService() {
        try{
            SecretKey k = KeyGenerator.getInstance("HmacSHA256").generateKey();
            secretKey = Keys.hmacShaKeyFor(k.getEncoded());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getToken(){
        return Jwts.builder()
                .subject("nipun")//Use UserName
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+1000*60*15))
                .signWith(secretKey)
                .compact();
    }

    public String getUserName(String token){
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseEncryptedClaims(token)
                .getPayload()
                .getSubject();
    }
}
