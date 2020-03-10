package com.fatihmayuk.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class TokenManager {

    //private static final String secretKey = "fatihmyk";
    private static final int validity = 5 * 60 * 1000;
    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(String username){

       return Jwts.builder()
                .setSubject(username)
                .setIssuer("www.fatihmayuk.com")             //Bunu kim imzaladı(yarattı)
                .setIssuedAt(new Date(System.currentTimeMillis()))          // Yaratan hangi tarihte yarattı
                .setExpiration(new Date(System.currentTimeMillis() + validity))         //Ne zamana kadar geçerli
                .signWith(key)
                .compact();

    }

    public boolean tokenValidate(String token){

        if (getUsernameToken(token) != null && isExpiredToken(token)){
            return true;
        }

        return false;

    }

    public String getUsernameToken(String token){
        Claims claims = getClaims(token);
        return claims.getSubject();
    }

    public boolean isExpiredToken(String token){
        Claims claims = getClaims(token);
        return claims.getExpiration().after(new Date(System.currentTimeMillis()));
    }

    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    }

}
