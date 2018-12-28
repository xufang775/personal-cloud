//package com.personal.cloud.zuul.filters;
//
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Created by xufan on 2018/12/28.
// */
//@Component
//
//public class FirstFilter extends ZuulFilter {
//
//
//
//    private Logger logger = LoggerFactory.getLogger(FirstFilter.class);
//
//
//
//    @Override
//
//    public String filterType() {
//
//        /*
//
//        pre：可以在请求被路由之前调用
//
//        route：在路由请求时候被调用
//
//        post：在route和error过滤器之后被调用
//
//        error：处理请求时发生错误时被调用
//
//        * */
//
//        // 前置过滤器
//
//        return FilterConstants.PRE_TYPE;
//
//    }
//
//
//
//    @Override
//
//    public int filterOrder() {
//
//        //// 优先级为0，数字越大，优先级越低
//
//        return 0;
//
//    }
//
//    @Override
//
//    public boolean shouldFilter() {
//
//        RequestContext ctx = RequestContext.getCurrentContext();
//
//        HttpServletRequest request = ctx.getRequest();
//
//        //只过滤OPTIONS 请求
//
//        if(request.getMethod().equals(RequestMethod.OPTIONS.name())){
//
//            return true;
//
//        }
//
//
//
//        return false;
//
//    }
//
//
//
//    @Override
//
//    public Object run() {
//
//        logger.debug("*****************FirstFilter run start*****************");
//
//        RequestContext ctx = RequestContext.getCurrentContext();
//
//        HttpServletResponse response = ctx.getResponse();
//
//        HttpServletRequest request = ctx.getRequest();
//
//        response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
//
//        response.setHeader("Access-Control-Allow-Credentials","true");
//
//        response.setHeader("Access-Control-Allow-Headers","authorization, content-type");
//
//        response.setHeader("Access-Control-Allow-Methods","POST,GET");
//
//        response.setHeader("Access-Control-Expose-Headers","X-forwared-port, X-forwarded-host");
//
//        response.setHeader("Vary","Origin,Access-Control-Request-Method,Access-Control-Request-Headers");
//
//        //不再路由
//
//        ctx.setSendZuulResponse(false);
//
//        ctx.setResponseStatusCode(200);
//
//        logger.debug("*****************FirstFilter run end*****************");
//
//        return null;
//
//    }
//
//}
