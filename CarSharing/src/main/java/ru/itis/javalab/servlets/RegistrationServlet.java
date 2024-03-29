package ru.itis.javalab.servlets;

import ru.itis.javalab.models.User;
import ru.itis.javalab.services.UsersService;
import ru.itis.javalab.utils.MD5PasswordHasher;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    UsersService usersService;

    @Override
    public void init(ServletConfig config) throws ServletException {

        ServletContext servletContext = config.getServletContext();
        usersService = (UsersService) servletContext.getAttribute("usersService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("freemarker/registration.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String phone = req.getParameter("phone");
        String password = req.getParameter("password");

        if (!Pattern.matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$", phone)) {
            req.setAttribute("badPhoneNumber", "Неверный формат номера");;
        }
        if (!Pattern.matches("^(?=.{10,}$)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*\\W).*$", password)) {
            req.setAttribute("badPassword", "Неверный формат пароля");
        }

        if (req.getAttribute("badPhoneNumber") != null || req.getAttribute("badPassword") != null) {
            req.getRequestDispatcher("freemarker/registration.ftl").forward(req, resp);
        }
        else {
            User newUser = User.builder()
                    .firstName(req.getParameter("first_name"))
                    .lastName(req.getParameter("last_name"))
                    .login(req.getParameter("login"))
                    .email(req.getParameter("email"))
                    .phone(phone)
                    .password(MD5PasswordHasher.getHashPassword(password))
                    .avatar("../pictures/default_user.jpg")
                    .build();

            if (!usersService.getSuchUserForRegistration(newUser).isPresent()) {
                usersService.saveUser(newUser);
                resp.sendRedirect("/sign_in");
            }
            else {
                req.setAttribute("suchUser", "Пользователь с такими данными уже существует");
                req.getRequestDispatcher("freemarker/registration.ftl").forward(req, resp);
            }
        }
    }
}
