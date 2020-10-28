package ru.itis.javalab.services;

import ru.itis.javalab.models.Feedback;
import ru.itis.javalab.models.User;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public interface FeedbacksService {

    void saveFeedback(Feedback feedback);

    List<Feedback> getAllFeedbacks();

}
