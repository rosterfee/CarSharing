package ru.itis.javalab.servlets;

import ru.itis.javalab.models.Car;
import ru.itis.javalab.services.CarImagesService;
import ru.itis.javalab.services.CarsService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/add_car")
@MultipartConfig
public class AddCarServlet extends HttpServlet {

    CarsService carsService;
    CarImagesService carImagesService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();

        carsService = (CarsService) servletContext.getAttribute("carsService");
        carImagesService = (CarImagesService) servletContext.getAttribute("carImagesService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("freemarker/add_car.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Car car = Car.builder()
                .mark(req.getParameter("mark"))
                .model(req.getParameter("model"))
                .price(Integer.parseInt(req.getParameter("price")))
                .powers(Integer.parseInt(req.getParameter("powers")))
                .engine(Double.parseDouble(req.getParameter("engine")))
                .transmission(req.getParameter("transmission"))
                .maxSpeed(Integer.parseInt(req.getParameter("max_speed")))
                .racing(Double.parseDouble(req.getParameter("racing")))
                .description(req.getParameter("description"))
                    .build();
        carsService.save(car);

        car = carsService.getCarByName(car.getMark() + " " + car.getModel()).get();

        InputStream inputStream;
        for (int i = 1; i < 4; i++) {
            inputStream = req.getPart("file" + i).getInputStream();
            carImagesService.save(inputStream, car.getId());
        }

        System.out.print(carsService.getCarById(car.getId()).get().getPhotos().size());

    }
}
