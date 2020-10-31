package ru.itis.javalab.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/choose_city")
public class CityChooseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String city = req.getParameter("city");

        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("city", city);

        Cookie[] cookies = req.getCookies();
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("city")) {
                cookie.setValue(city);
            }
        }

        resp.sendRedirect(req.getContextPath() + "/main");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
