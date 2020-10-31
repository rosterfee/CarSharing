package ru.itis.javalab.servlets;

import ru.itis.javalab.models.Order;
import ru.itis.javalab.services.OrderService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete_order")
public class DeleteOrderServlet extends HttpServlet {

    OrderService orderService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        orderService = (OrderService) servletContext.getAttribute("ordersService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long orderId = Long.parseLong(req.getParameter("order_id"));
        Order order = orderService.getOrderById(orderId).get();
        orderService.deleteOrder(order);

        resp.sendRedirect(req.getContextPath() + "/my_order");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
