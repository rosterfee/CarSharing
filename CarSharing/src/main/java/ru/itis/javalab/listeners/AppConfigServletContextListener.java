package ru.itis.javalab.listeners;

import ru.itis.javalab.repositories.FeedbacksRepository;
import ru.itis.javalab.repositories.FeedbacksRepositoryJdbcImpl;
import ru.itis.javalab.repositories.UsersRepository;
import ru.itis.javalab.repositories.UsersRepositoryJdbcImpl;
import ru.itis.javalab.services.FeedbacksService;
import ru.itis.javalab.services.FeedbacksServiceImpl;
import ru.itis.javalab.services.UsersService;
import ru.itis.javalab.services.UsersServiceImpl;
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

        servletContext.setAttribute("usersService", usersService);
        servletContext.setAttribute("feedbacksService", feedbacksService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
