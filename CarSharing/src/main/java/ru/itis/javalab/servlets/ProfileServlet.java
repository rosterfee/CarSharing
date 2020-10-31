package ru.itis.javalab.servlets;

import ru.itis.javalab.models.Order;
import ru.itis.javalab.models.User;
import ru.itis.javalab.services.OrderService;
import ru.itis.javalab.services.UsersService;
import ru.itis.javalab.utils.MD5PasswordHasher;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    UsersService usersService;
    OrderService orderService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        usersService = (UsersService) servletContext.getAttribute("usersService");
        orderService = (OrderService) servletContext.getAttribute("ordersService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession();
        User user = (User) httpSession.getAttribute("user");
        req.setAttribute("user", user);

        List<Order> userOrders = orderService.getAllNonActiveByUserId(user.getId());
        req.setAttribute("orders", userOrders);

        req.getRequestDispatcher("freemarker/profile.ftl").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String phone = req.getParameter("phone");
        String password = req.getParameter("password");

        if (!Pattern.matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$", phone)) {
            req.setAttribute("badPhoneNumber", "Неверный формат номера телефона");;
        }
        if (!Pattern.matches("^(?=.{10,}$)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*\\W).*$", password)) {
            req.setAttribute("badPassword", "Пароль должен состоять минимум из 10 символов, содержать " +
                    "нижний и верхний регистры, содержать цифры и специальные знаки");
        }

        if (req.getAttribute("badPhoneNumber") != null || req.getAttribute("badPassword") != null) {
            req.getRequestDispatcher("freemarker/profile.ftl").forward(req, resp);
        }
        else {
            User user = (User) req.getSession().getAttribute("user");
            User updatedUser = User.builder()
                    .firstName(req.getParameter("first_name"))
                    .lastName(req.getParameter("last_name"))
                    .login(req.getParameter("login"))
                    .email(req.getParameter("email"))
                    .phone(phone)
                    .password(MD5PasswordHasher.getHashPassword(password))
                    .avatar(user.getAvatar())
                    .id(user.getId())
                    .build();

            usersService.updateUser(updatedUser);
            req.setAttribute("user", usersService.getUserById(user.getId()).get());

            req.getRequestDispatcher("freemarker/profile.ftl").forward(req, resp);
        }
    }
}
