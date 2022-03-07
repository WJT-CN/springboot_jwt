package com.wjt.springboot_jwt.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jdk.nashorn.internal.parser.Token;

import java.util.Calendar;
import java.util.Map;

public class JWTUtils {

    private static final String TOKEN = "ASH@#%155!GFG";

    //生成token
    public static String getToken(Map<String,String> map){
        JWTCreator.Builder builder = JWT.create();

        map.forEach((k,v) -> {
            builder.withClaim(k,v);
        });

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND,7);

        builder.withExpiresAt(instance.getTime());
        String token = builder.sign(Algorithm.HMAC256(TOKEN));
        return token;
    }

    //验证token
    public static void verity(String token){
        JWT.require(Algorithm.HMAC256(TOKEN)).build().verify(token);
    }

    //获取token中的payload
    public static DecodedJWT getToken(String token){
        return JWT.require(Algorithm.HMAC256(TOKEN)).build().verify(token);
    }
}
