package com.personal.common.constant;

/**
 * Created by xufan on 2018/11/14.
 */
public final class HttpCode {
    public static final int success = 20000;  // 请求成功
    public static final int fail = 40001;   // 请求失败
    public static final int error = 20001;  // 请求成功
    public static final int feifa = 50008;    // 非法的token
    public static final int logined = 50012;  // 其他客户端登录了
    public static final int guoqi = 50014;    // Token 过期了
}
