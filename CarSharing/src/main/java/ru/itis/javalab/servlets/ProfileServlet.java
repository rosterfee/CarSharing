package ru.itis.javalab.servlets;

import ru.itis.javalab.models.User;
import ru.itis.javalab.services.UsersService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    UsersService usersService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        usersService = (UsersService) servletContext.getAttribute("usersService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession();

        User user = (User) httpSession.getAttribute("user");
        Optional<String> optionalAvatar = usersService.getAvatarByLogin(user.getLogin());
        if (optionalAvatar.isPresent()) {
            user.setAvatar(optionalAvatar.get());
            httpSession.setAttribute("user", user);
        }

        user = (User) httpSession.getAttribute("user");
        String avatar = user.getAvatar();
        if (avatar == null) {
            req.setAttribute("avatar", "../pictures/default_user.jpg");
        }
        else req.setAttribute("avatar", avatar);

        req.getRequestDispatcher("freemarker/profile.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
