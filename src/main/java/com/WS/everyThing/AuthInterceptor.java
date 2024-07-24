package com.WS.everyThing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.WS.Entity.User;
import com.WS.Service.SessionService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Service
public class AuthInterceptor implements HandlerInterceptor {
    @Autowired
    SessionService session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        User user = session.get("user",null);
        String error = "";

        if (user == null) {
            error = "Please login now!";
        } else if (!user.isAdmin() && uri.startsWith("/admin/")) {
            error = "Access denied!";
        }       
        if (error.length() > 0) {
            session.set("security-uri", uri);
            session.remove("user");
            response.sendRedirect("/login?error=" + error);
            return false;
        }

        return true;
    }
}

