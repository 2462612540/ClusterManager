package cluster.manager.srs;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;

@SpringBootTest
class JwtTest {

    /**
     * @description TODO 创建token
     * @param:
     * @date: 2021/8/22 10:26
     * @return: void
     * @author: xjl
     */
    @Test
    void genter() {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 10000);
        String token = JWT.create()
                .withClaim("username", "jiale_x")//自动以用户名设置
                .withExpiresAt(instance.getTime())//设置过期时间
                .sign(Algorithm.HMAC256("token!xjljfalkh"));//设置签名保密复杂
        System.out.println(token);
    }

    /**
     * @description TODO 解析token
     * @param:
     * @date: 2021/8/22 10:26
     * @return: void
     * @author: xjl
     */
    @Test
    void explain() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2Mjk2MDk1OTksInVzZXJuYW1lIjoiamlhbGVfeCJ9.iKLLIQU053qjI1uHGJ9fgiGMCGJS6Yzj1z30BpZmV8E";
        JWTVerifier jWTVerifier = JWT.require(Algorithm.HMAC256("token!xjljfalkh")).build();//先验证算法
        DecodedJWT decodedJWT = jWTVerifier.verify(token);//验证密码
        System.out.println("用户名的=" + decodedJWT.getClaim("username").asString());//获取token的值对象
        System.out.println("过期时间为=" + decodedJWT.getExpiresAt());
    }

}
