package com.example.global.jwt;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {
    private SecretKey secretKey;
    public JwtUtil(@Value("spring.jwt.secret") String secret) {
        secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), Jwts.SIG.HS256.key().build().getAlgorithm());
    }
    public String getUserName(String token){
        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().get("userName", String.class);
    }
    public Boolean isExpired(String token){
        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().getExpiration().before(new Date());
    }
    public String createToken(String userName) {
        return Jwts.builder()
                .claim("userName", userName)
                .issuedAt(new Date(System.currentTimeMillis()))//만든 시간 솔직히 안써도 될꺼 같은데
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12))
                .signWith(secretKey)
                .compact();
    }
}


