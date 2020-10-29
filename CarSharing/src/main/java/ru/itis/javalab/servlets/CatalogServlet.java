package ru.itis.javalab.servlets;

import ru.itis.javalab.models.Car;
import ru.itis.javalab.services.CarsService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/catalog")
public class CatalogServlet extends HttpServlet {

    CarsService carsService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        carsService = (CarsService) servletContext.getAttribute("carsService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Car> cars = carsService.getAll();
        req.setAttribute("cars", cars);

        req.getRequestDispatcher("freemarker/catalog.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
