package com.example.portfolio.service.common.utils;

import com.example.portfolio.service.core.user.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret-key}")
    private String SECRET_KEY ;

    private long EXPIRATION_TIME = 86400000;


    public SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY));
    }

    public String generateToken ( User user){
        return Jwts.builder()
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256,getSecretKey())
                .compact();
    }

    public String extractUsername (String token) {
        return getClaims(token).getSubject();
    }

    public Claims getClaims (String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSecretKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public Boolean isValidToken (String token, UserDetails userDetails) {
      final String username = getClaims(token).getSubject();
      return  username.equalsIgnoreCase(userDetails.getUsername()) && !isTokenExpired(token);
    }

    public Boolean isTokenExpired (String token) {
        return getClaims(token).getExpiration().before(new Date());
    }
}
