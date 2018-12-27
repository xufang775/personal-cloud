package com.personal.cloud.login.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Created by xufan on 2018/11/9.
 */
public class JWTToken implements AuthenticationToken {
    private String token;
    public JWTToken(String token){
        this.token = token;
    }
    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
