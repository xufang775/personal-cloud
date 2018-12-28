//package com.personal.cloud.zuul.filters;
//
//import com.personal.common.constant.AppConstants;
//import com.personal.common.utils.IPAddressUtils;
//import com.personal.cloud.zuul.service.RedisService;
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.UnsupportedEncodingException;
//import java.util.Enumeration;
//
//public class AccessFilter extends ZuulFilter {
//
//    private static final String TAG = "AccessFilter";
//    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);
//
//    private static final String[] extraPath = {"/api-mulidb/dictype/*", "/api-login/**",
//            "/api-system/**", "/api-corp/**", "/api-hd/**", "/api-mobile/**", "/zuul/**",
//            "/api-app-system/**", "/api-app-hd/**", "/api-operate/**","/api-government/**",
//            "/api-login-shiro/**","/api-platform/**","/api-commons/**","/api-app-corp/**"};
//    private static  final String SYSTEM_SOURCE  = "x-cos-meta-source";
//
//    @Autowired
//    private RedisService redisService;
//
//    @Override
//    public String filterType() {
//        return "pre";
//    }
//
//    @Override
//    public int filterOrder() {
//        return 0;
//    }
//
//    @Override
//    public boolean shouldFilter() {
//        return true;
//    }
//
//    @Override
//    public Object run() {
//        RequestContext requestContext = RequestContext.getCurrentContext();
//        requestContext.getResponse().setCharacterEncoding("UTF-8");
//        requestContext.getResponse().setHeader("Content-Type", "application/json; charset=utf-8");
//        requestContext.getResponse().setContentType("application/json;charset=utf-8");
//        HttpServletRequest request = requestContext.getRequest();
//        log.info(String.format("%s request to %s", new Object[]{request.getMethod(), request.getRequestURI()}));
//        //获取http request header 获取访问来源
//        Enumeration headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String key = (String) headerNames.nextElement();
//            if(SYSTEM_SOURCE.equals(key)) {
//                String value = request.getHeader(key);
//                request.getSession().setAttribute(AppConstants.SYSTEM_SOURCE_KEY,value);
//                log.info(String.format(" request system source %s", new Object[]{value}));
//                break;
//            }
//        }
//        String visitPath = request.getRequestURI();
//        Object accessToken = request.getParameter("token");
//        String ip = ""; // IPAddressUtils.getRealIP(request);
//        if(request.getRequestURI().indexOf("login")!= -1) {
//            request.getSession().setAttribute("ip", ip);
//            new Thread( () -> {
//                try {
//                    request.getSession().setAttribute("address", IPAddressUtils.getAddressByIp(ip) );
////                    request.getSession().setAttribute("address", "" );
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                    log.error("ip is fail :"+e.getLocalizedMessage());
//                }
//            }).start();
//            // log.info(String.format("visitor request ip : %s ,address: %s", new Object[]{ip, IPAddressUtils.getAddressByIp(ip)}));
//        }
//        if (isExistPath(visitPath)) {
//            return null;
//        }
//        if (null == accessToken) {
//            log.warn("token is empty!");
//            requestContext.setSendZuulResponse(false);
//            requestContext.setResponseBody("对不起，您没有访问权限！");
//            requestContext.setResponseStatusCode(401);
//            return null;
//        }
////        boolean exist = this.redisService.hexists("anhry_login_user_token_list", accessToken.toString());
//        boolean exist =true; // this.redisService.hexists("anhry_login_user_token_list", accessToken.toString());
//        if (!exist) {
//            requestContext.setSendZuulResponse(false);
//            requestContext.setResponseBody("对不起，您没有访问权限！-token不存在");
//            requestContext.setResponseStatusCode(401);
//            return null;
//        }
//
//        log.info("accessToken is ok!");
//        return null;
//    }
//
//    private boolean isExistPath(String visitPath) {
//        for (String path : extraPath) {
//            if (path.contains("*")) {
//                String curPath = path.substring(0, path.indexOf("*"));
//                if (visitPath.startsWith(curPath))
//                    return true;
//            } else {
//                return path.equals(visitPath);
//            }
//
//        }
//        return false;
//    }
//}