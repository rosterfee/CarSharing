package ru.itis.javalab.servlets;

import ru.itis.javalab.models.User;
import ru.itis.javalab.services.UsersService;
import ru.itis.javalab.utils.MD5PasswordHasher;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/sign_in")
public class SignInServlet extends HttpServlet {

    ServletContext servletContext;
    UsersService usersService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        servletContext = config.getServletContext();
        usersService = (UsersService) servletContext.getAttribute("usersService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("freemarker/sign_in.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String hashedPassword = MD5PasswordHasher.getHashPassword(password);

        req.setAttribute("badLoginOrPassword", false);

        Optional<User> user = usersService.getSuchUserForSignIn(login, hashedPassword);
        if (user.isPresent()) {

            req.getSession().setAttribute("user", user.get());

            if (req.getParameter("remember_me") != null) {
                resp.addCookie(new Cookie("usersLogin", login));
            }

            resp.sendRedirect("/main");
        }
        else {
            req.setAttribute("badLoginOrPassword", true);
            req.getRequestDispatcher("/sign_in.ftl").forward(req, resp);
        }
    }
}
