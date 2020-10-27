package ru.itis.javalab.filters;

import ru.itis.javalab.models.User;
import ru.itis.javalab.services.UsersService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {

    UsersService usersService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext = filterConfig.getServletContext();
        usersService = (UsersService) servletContext.getAttribute("usersService");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (user == null) {

            Cookie[] cookies = httpServletRequest.getCookies();
            Cookie userCookie = null;
            for (Cookie cookie: cookies) {
                if (cookie.getName().equals("usersLogin")) {
                    userCookie = cookie;
                    break;
                }
            }
            if (userCookie != null) {
                httpServletRequest.getSession().setAttribute("user",
                        usersService.getUserByLogin(userCookie.getValue()).get());
            }

        }

        user = (User) httpServletRequest.getSession().getAttribute("user");
        if (user != null) {
            if (user.getLogin().equals("admin")) {
                httpServletRequest.setAttribute("admin", "kostil");
            }
            else httpServletRequest.setAttribute("auth", "kostil");
        }
        else httpServletRequest.setAttribute("non_auth", "kostil");

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    @Override
    public void destroy() {

    }
}
