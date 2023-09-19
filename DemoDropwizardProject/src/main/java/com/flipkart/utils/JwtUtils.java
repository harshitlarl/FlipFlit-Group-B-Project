package com.flipkart.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.SignatureException;

import java.security.Key;

public class JwtUtils {


    // Secret key to verify the JWT
    public static boolean verifyJwtToken(String token, Key key) {
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(token);
            return true; // Token is valid
        } catch (SignatureException e) {
            // Token signature is invalid
            return false;
        } catch (Exception e) {
            // Other token validation errors
            return false;
        }
    }

    // Rest of your code...
}