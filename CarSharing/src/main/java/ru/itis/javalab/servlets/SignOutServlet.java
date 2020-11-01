package ru.itis.javalab.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/sign_out")
public class SignOutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        session.removeAttribute("user");

        Cookie[] cookies = req.getCookies();
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("usersId")) {
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
                break;
            }
        }

        resp.sendRedirect(req.getContextPath() + "/sign_in");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
