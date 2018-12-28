package com.personal.cloud.zuul;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
//import org.springframework.session.data.redis.RedisFlushMode;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//import com.personal.cloud.zuul.filters.AccessFilter;
//import com.personal.cloud.zuul.filters.SessionPreFilter;
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
//@EnableRedisHttpSession(redisFlushMode = RedisFlushMode.IMMEDIATE, maxInactiveIntervalInSeconds = 3600 * 12)
public class CloudZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudZuulApplication.class, args);
    }

//    @Bean
//    public SessionPreFilter sessionPreFilter() {
//        return new SessionPreFilter();
//    }

//    @Bean
//    public AccessFilter accessFilter() {
//        return new AccessFilter();
//    }

//    @Bean
//    public JWTFilter accessFilter() {
//        return new JWTFilter();
//    }

}
