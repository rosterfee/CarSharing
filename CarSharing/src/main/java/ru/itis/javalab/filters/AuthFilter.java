package ru.itis.javalab.filters;

import ru.itis.javalab.services.UsersService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/profile", "/my_order"})
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

        if (httpServletRequest.getSession().getAttribute("user") ==  null) {

            Cookie[] cookies = httpServletRequest.getCookies();
            Cookie userCookie = null;
            for (Cookie cookie: cookies) {
                if (cookie.getName().equals("login")) {
                    userCookie = cookie;
                    break;
                }
            }
            if (userCookie != null) {
                httpServletRequest.getSession().setAttribute("user",
                        usersService.getUserByLogin(userCookie.getValue()));
            }
            else {
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/sign_in");
            }
        }
        else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
