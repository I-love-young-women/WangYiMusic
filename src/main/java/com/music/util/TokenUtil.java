package com.music.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.Map;

public class TokenUtil {
    @Value("secret")
    private static String secret="qwertyui";
    //生成token
    public static String makeToken(Map<String,Object> claims){
        Date date=new Date(System.currentTimeMillis()+1000*60*60*24
        );
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }
    //解析token
    public static Claims parseToken(String token){
        return Jwts.parser().setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}
