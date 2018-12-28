package com.personal.cloud.zuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.session.Session;
//import org.springframework.session.SessionRepository;

import javax.servlet.http.HttpSession;

/**
 * session
 * Created by zhang on 2017/6/26.
 */
//public class SessionPreFilter extends ZuulFilter {
//    @Autowired
//    private SessionRepository<?> repository;
//
//    @Override
//    public String filterType() {
//        return "pre";
//    }
//
//    @Override
//    public int filterOrder() {
//        return 1;
//    }
//
//    @Override
//    public boolean shouldFilter() {
//        return true;
//    }
//
//    @Override
//    public Object run() {
//        RequestContext ctx = RequestContext.getCurrentContext();
//        HttpSession httpSession = ctx.getRequest().getSession();
//        Session session = repository.getSession(httpSession.getId());
//        System.out.println(session.getId());
//        ctx.addZuulRequestHeader("Cookie", "SESSION=" + session.getId());
//        return null;
//    }
//
//}
