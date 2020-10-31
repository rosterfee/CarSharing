package ru.itis.javalab.servlets;

import ru.itis.javalab.models.Order;
import ru.itis.javalab.models.User;
import ru.itis.javalab.services.OrderService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/my_order")
public class MyOrderServlet extends HttpServlet {

    OrderService orderService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        orderService = (OrderService) servletContext.getAttribute("ordersService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");

        Optional<Order> optionalOrder = orderService.getActiveOrderByUserId(user.getId());;
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            req.setAttribute("order", order);
        }

        req.getRequestDispatcher("freemarker/my_order.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int hours = Integer.parseInt(req.getParameter("hours"));
        int car_price = Integer.parseInt(req.getParameter("car_price"));
        int totalPrice = hours * car_price / 4;

        long order_id = Long.parseLong(req.getParameter("order_id"));
        orderService.setOrderPrice(totalPrice, order_id);

        resp.sendRedirect(req.getContextPath() + "/pay_offer?order_id=" + order_id);

    }
}
