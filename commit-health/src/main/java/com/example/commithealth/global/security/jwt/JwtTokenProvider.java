package com.example.commithealth.global.security.jwt;

import com.example.commithealth.global.exception.ExpiredJwtException;
import com.example.commithealth.global.exception.InvalidJwtException;
import com.example.commithealth.global.exception.SignatureJwtException;
import com.example.commithealth.global.security.auth.AuthDetailsService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    @Value("${KEY}")
    private String JWT_SECRET;
    private final AuthDetailsService authDetailsService;

    public String getBearerToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public String getUserId(String token) {
        try {
            return Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody().getSubject();
        } catch (io.jsonwebtoken.ExpiredJwtException e) {
            throw ExpiredJwtException.EXCEPTION;
        } catch (io.jsonwebtoken.SignatureException e) {
            throw SignatureJwtException.EXCEPTION;
        } catch (Exception e) {
            throw InvalidJwtException.EXCEPTION;
        }
    }
    public String generateAccessToken(String studentId){
        return Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 840000000))
                .setSubject(studentId)
                .signWith(SignatureAlgorithm.HS256, JWT_SECRET)
                .compact();
    }
    public Authentication getAuthentication(String token){
        UserDetails userDetails = authDetailsService.loadUserByUsername(getUserId(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", null);
    }
}