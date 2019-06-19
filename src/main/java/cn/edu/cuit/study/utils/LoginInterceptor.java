package cn.edu.cuit.study.utils;

import cn.edu.cuit.study.constant.SessionNames;
import cn.edu.cuit.study.entity.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object user = request.getSession().getAttribute(SessionNames.SESSION_KEY_USER);

        if (user == null || user.equals("")){
            response.sendRedirect("/login.html");
            return false;
        }

        return true;
    }
}
