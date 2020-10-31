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

@WebServlet("/pay_confirmation")
public class PayConfirmationServlet extends HttpServlet {

    OrderService orderService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        orderService = (OrderService) servletContext.getAttribute("ordersService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long order_id = Long.parseLong(req.getParameter("order_id"));
        Order order = orderService.getOrderById(order_id).get();

        req.setAttribute("order", order);

        req.getRequestDispatcher("freemarker/pay_confirmation.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
