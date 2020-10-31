package ru.itis.javalab.listeners;

import ru.itis.javalab.repositories.*;
import ru.itis.javalab.services.*;
import ru.itis.javalab.utils.MyDataSource;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppConfigServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        ServletContext servletContext = servletContextEvent.getServletContext();

        MyDataSource myDataSource = new MyDataSource(
                "jdbc:postgresql://localhost:5432/CarSharing",
                "postgres",
                "gev56poison"
        );

        UsersRepository usersRepository = new UsersRepositoryJdbcImpl(myDataSource);
        UsersService usersService = new UsersServiceImpl(usersRepository);

        FeedbacksRepository feedbacksRepository = new FeedbacksRepositoryJdbcImpl(myDataSource, usersService);
        FeedbacksService feedbacksService = new FeedbacksServiceImpl(feedbacksRepository);

        CarImagesRepository carImagesRepository = new CarImagesRepositoryJdbcImpl(myDataSource);
        CarImagesService carImagesService = new CarImagesServiceImpl(carImagesRepository);

        CarsRepository carsRepository = new CarsRepositoryJdbcImpl(myDataSource, carImagesService);
        CarsService carsService = new CarsServiceImpl(carsRepository);

        OrdersRepository ordersRepository = new OrdersRepositoryJdbcImpl(myDataSource, usersService, carsService);
        OrderService orderService = new OrdersServiceImpl(ordersRepository);

        servletContext.setAttribute("usersService", usersService);
        servletContext.setAttribute("feedbacksService", feedbacksService);
        servletContext.setAttribute("carImagesService", carImagesService);
        servletContext.setAttribute("carsService", carsService);
        servletContext.setAttribute("ordersService", orderService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
