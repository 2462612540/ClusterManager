package cluster.manager.srs.controller;

import cluster.manager.srs.entity.User;
import cluster.manager.srs.service.UserService;
import cluster.manager.srs.utils.JwtUtils;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2021/8/22 15:50
 * @Created by xjl
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/login")
    public Map<String, Object> login(User user) {
        log.info("用户名：{}", user.getName());
        log.info("password: {}", user.getPassword());

        Map<String, Object> map = new HashMap<>();

        try {
            User userDB = userService.login(user);

            Map<String, String> payload = new HashMap<>();
            payload.put("id", userDB.getId());
            payload.put("name", userDB.getName());
            String token = JwtUtils.getToken(payload);

            map.put("state", true);
            map.put("msg", "登录成功");
            map.put("token", token);//响应token
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state", false);
            map.put("msg", e.getMessage());
            map.put("token", "");
        }
        return map;
    }

    @PostMapping("/user/test")
    public Map<String, Object> test(String token) {
        Map<String, Object> map = new HashMap<>();
        //处理你的业务逻辑》》》》》》》
        map.put("status", true);
        map.put("message", "请求成功");
        return map;
    }
}
