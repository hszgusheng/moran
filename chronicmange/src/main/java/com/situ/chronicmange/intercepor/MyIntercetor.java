package com.situ.chronicmange.intercepor;

import com.situ.chronicmange.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
* 自定义拦截器
* */
@Component //把当前类放入spring的bean中
public class MyIntercetor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        //判断用户是否登录
        if(user == null){
            response.sendRedirect("/login");
            return false;

        }
        return true;
    }
}
