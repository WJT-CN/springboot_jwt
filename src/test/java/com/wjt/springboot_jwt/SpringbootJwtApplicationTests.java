package com.wjt.springboot_jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;

@SpringBootTest
class SpringbootJwtApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test(){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND,100);
        String token = JWT.create().withClaim("userId", 12)//设置有效载荷
                .withClaim("username", "xiaoding")
                .withExpiresAt(instance.getTime())//设置过期时间
                .sign(Algorithm.HMAC256("jfjsog"));//设置签名
        System.out.println(token);
    }

    @Test
    void tset1(){
        JWTVerifier jfjsog = JWT.require(Algorithm.HMAC256("jfjsog")).build();
        DecodedJWT verify = jfjsog.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NDYzMTg4NDAsInVzZXJJZCI6MTIsInVzZXJuYW1lIjoieGlhb2RpbmcifQ.a-sTCTpKqkA6WoNG6pXWb0blQgp8GZ3TuagDcitcNbQ");
        System.out.println(verify.getClaim("userId").asInt());
        System.out.println(verify.getClaim("username").asString());
    }

}
