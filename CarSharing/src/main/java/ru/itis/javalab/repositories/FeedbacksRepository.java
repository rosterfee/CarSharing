package ru.itis.javalab.repositories;

import ru.itis.javalab.models.Feedback;

public interface FeedbacksRepository extends CrudRepository<Feedback> {

    @Override
    void save(Feedback feedback);

}
