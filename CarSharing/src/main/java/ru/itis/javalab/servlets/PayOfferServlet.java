package ru.itis.javalab.servlets;

import ru.itis.javalab.models.Order;
import ru.itis.javalab.services.OrderService;
import ru.itis.javalab.utils.StringDateGenerator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pay_offer")
public class PayOfferServlet extends HttpServlet {

    OrderService orderService;

    @Override
    public void init(ServletConfig config) throws ServletException {

        ServletContext servletContext = config.getServletContext();
        orderService = (OrderService) servletContext.getAttribute("ordersService");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String city = String.valueOf(req.getAttribute("city"));
        if (city.equals("Казань")) {
            req.setAttribute("kazan", "kostil");
        }
        else if (city.equals("Москва")) {
            req.setAttribute("moscow", "kostil");
        }
        else if (city.equals("Санкт-Петербург")) {
            req.setAttribute("petersburg", "kostil");
        }

        long order_id = Long.parseLong(req.getParameter("order_id"));

        req.setAttribute("order_id", order_id);
        Order order = orderService.getOrderById(order_id).get();
        req.setAttribute("sum", order.getPrice());

        req.getRequestDispatcher("freemarker/pay_offer.ftl").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String date = String.valueOf(req.getParameter("date"));
        String address = String.valueOf(req.getParameter("address"));

        long order_id = Long.parseLong(req.getParameter("order_id"));

        orderService.setOrderAddress(address, order_id);
        orderService.setTimeOfOrderTaking(date, order_id);
        orderService.setOrderDate(StringDateGenerator.getCurrentStringDate(), order_id);
        orderService.setOrderNonActive(order_id);

        resp.sendRedirect(req.getContextPath() + "/pay_confirmation?order_id=" + order_id);

    }
}
