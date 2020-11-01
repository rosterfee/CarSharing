package ru.itis.javalab.servlets;

import ru.itis.javalab.models.User;
import ru.itis.javalab.services.UsersService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/choose_city")
public class CityChooseServlet extends HttpServlet {

    UsersService usersService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        usersService = (UsersService) config.getServletContext().getAttribute("usersService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession();
        User user = (User) httpSession.getAttribute("user");
        usersService.setUserCity(req.getParameter("city"), user.getId());
        httpSession.setAttribute("user", usersService.getUserById(user.getId()).get());

        resp.sendRedirect(req.getContextPath() + "/main");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
