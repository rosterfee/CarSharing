package ru.itis.javalab.filters;

import ru.itis.javalab.models.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class HeaderLoadFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();

        if (session.getAttribute("user") == null) {
            session.setAttribute("head", "non_authorised");
        }
        else {
            User user = (User) session.getAttribute("user");
            if (user.getLogin().equals("admin")) {
                session.setAttribute("head", "admin");
            } else session.setAttribute("head", "authorised");
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
