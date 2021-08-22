package cluster.manager.srs.config;

import cluster.manager.srs.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xjl
 * @Classname InterceptorConfig
 * @Description TODO
 * @Date 2021/8/22 23:22
 * @Created by xjl
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptor())
                .addPathPatterns("/user/test")//拦截其他接口程序
                .excludePathPatterns("/user/login")//所有的用户的都可以放行
        ;
    }
}
