//package com.personal.cloud.zuul.config;
//
//import org.springframework.web.filter.CorsFilter;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
///**
// * Created by xufan on 2018/12/28.
// */
//@Configuration
//public class CorsConfig {
//    private CorsConfiguration buildConfig(){
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.addAllowedOrigin("*");
//        corsConfiguration.addAllowedHeader("*");
//        corsConfiguration.addAllowedMethod("*");
//        corsConfiguration.setAllowCredentials(true);
//        return corsConfiguration;
//    }
//
//    public CorsFilter corsFilter(){
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", buildConfig());
//        return new org.springframework.web.filter.CorsFilter(source);
//    }
//}
