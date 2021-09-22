package com.example.payment.auth.utils;


import com.example.payment.auth.AuthConstants;
import com.example.payment.auth.UserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;
import java.util.Date;

@Component
public class JWTUtils {

    public String generateJWTToken(Authentication authentication){
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + AuthConstants.EXPIRATION_TIME * 1000);
        return Jwts.builder()
                .setSubject(userPrincipal.getLogin_ID())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, AuthConstants.SECRET)
                .compact();
    }

    public static String getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(AuthConstants.SECRET)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public static Boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(AuthConstants.SECRET).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
           // logger.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            // logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            //logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            // logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            // logger.error("JWT claims string is empty.");
        }
        return false;
    }
}
