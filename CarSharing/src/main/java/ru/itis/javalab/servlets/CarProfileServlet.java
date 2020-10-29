package ru.itis.javalab.servlets;

import ru.itis.javalab.models.Car;
import ru.itis.javalab.models.Order;
import ru.itis.javalab.models.User;
import ru.itis.javalab.services.CarsService;
import ru.itis.javalab.services.OrderService;
import ru.itis.javalab.utils.StringDateGenerator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/car_profile")
public class CarProfileServlet extends HttpServlet {

    CarsService carsService;
    OrderService ordersService;

    @Override
    public void init(ServletConfig config) throws ServletException {

        ServletContext servletContext = config.getServletContext();

        carsService = (CarsService) servletContext.getAttribute("carsService");
        ordersService = (OrderService) servletContext.getAttribute("ordersService");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Car car = carsService.getCarById(Long.parseLong(req.getParameter("id"))).get();
        req.setAttribute("car", car);

        req.getRequestDispatcher("freemarker//car_profile.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession();
        User user = (User) httpSession.getAttribute("user");

        if (user != null) {

            Order order = Order.builder()
                    .userId(user.getId())
                    .carId(Long.parseLong(req.getParameter("car_id")))
                    .active("active")
                    .date(StringDateGenerator.getCurrentStringDate())
                        .build();

            ordersService.saveOrder(order);

            resp.sendRedirect(req.getContextPath() + "/my_order");
        }
        else {
            resp.sendRedirect(req.getContextPath() + "/sign_in");
        }
    }
}
