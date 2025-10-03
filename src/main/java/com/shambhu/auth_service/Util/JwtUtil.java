package com.shambhu.auth_service.Util;

import com.shambhu.auth_service.entity.accounting.User;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "7CA6AFDA-B94C-4CCF-AC45-7C802BR5745F";

    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public void validateToken(String token) throws JwtException {
        Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJwt(token).getBody();
    }

    public String generateToken(UserDetails userDetails, User user, Long userId){
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", user.getRole());
        claims.put("userId", userId);
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .addClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+ 86400000))
                .signWith(key, SignatureAlgorithm.HS256).compact();
    }
}
