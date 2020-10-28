package ru.itis.javalab.services;

import ru.itis.javalab.models.Feedback;
import ru.itis.javalab.repositories.FeedbacksRepository;

import java.util.List;

public class FeedbacksServiceImpl implements FeedbacksService {

    FeedbacksRepository feedbacksRepository;

    public FeedbacksServiceImpl(FeedbacksRepository feedbacksRepository) {
        this.feedbacksRepository = feedbacksRepository;
    }

    @Override
    public void saveFeedback(Feedback feedback) {
        feedbacksRepository.save(feedback);
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbacksRepository.findAll();
    }
}
