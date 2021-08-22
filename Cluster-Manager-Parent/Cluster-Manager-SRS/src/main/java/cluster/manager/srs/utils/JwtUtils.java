package cluster.manager.srs.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * @Classname JWTUtils
 * @Description TODO  用于生产token和解析token的工具类
 * @Date 2021/8/22 10:44
 * @Created by xjl
 * @author: xjl
 */
public class JwtUtils {

    private static String TOKEN = "token!jiale_x";

    /**
     * @description TODO 生产token
     * @param: map
     * @date: 2021/8/22 10:49
     * @return: java.lang.String
     * @author: xjl
     */
    public static String getToken(Map<String, String> map) {
        JWTCreator.Builder builder = JWT.create();
        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 60);
        builder.withExpiresAt(instance.getTime());
        return builder.sign(Algorithm.HMAC256(TOKEN)).toString();
    }

    /**
     * @description TODO 验证token
     * @param: token
     * @date: 2021/8/22 10:52
     * @return: void
     * @author: xjl
     */
    public static DecodedJWT verify(String token) {
        return JWT.require(Algorithm.HMAC256(TOKEN)).build().verify(token);
    }
}
