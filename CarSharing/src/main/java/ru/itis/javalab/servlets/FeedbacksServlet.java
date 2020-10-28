package ru.itis.javalab.servlets;

import lombok.SneakyThrows;
import ru.itis.javalab.models.Feedback;
import ru.itis.javalab.models.User;
import ru.itis.javalab.services.FeedbacksService;
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
import java.text.SimpleDateFormat;
import java.util.Calendar;

@WebServlet("/feedbacks")
public class FeedbacksServlet extends HttpServlet {

    FeedbacksService feedbacksService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        feedbacksService = (FeedbacksService) servletContext.getAttribute("feedbacksService");
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession();
        User user = (User) httpSession.getAttribute("user");
        req.setAttribute("user", user);

        req.setAttribute("feedbacks", feedbacksService.getAllFeedbacks());

        req.getRequestDispatcher("freemarker/feedback.ftl").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession();
        User user = (User) httpSession.getAttribute("user");

        String text = req.getParameter("text");

        String currentDate = StringDateGenerator.getCurrentStringDate();

        Feedback feedback = Feedback.builder()
                .text(text)
                .date(currentDate)
                .user(user)
                    .build();

        feedbacksService.saveFeedback(feedback);

        doGet(req, resp);

    }
}
