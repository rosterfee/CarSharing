package ru.itis.javalab.repositories;

import ru.itis.javalab.models.Feedback;
import ru.itis.javalab.services.UsersService;
import ru.itis.javalab.utils.MyDataSource;

import java.util.List;
import java.util.Optional;

public class FeedbacksRepositoryJdbcImpl implements FeedbacksRepository {

    SimpleJdbcTemplate template;
    UsersService usersService;

    private RowMapper<Feedback> feedbackRowMapper = resultSet -> Feedback.builder()
            .id(resultSet.getLong("id"))
            .text(resultSet.getString("text"))
            .date(resultSet.getString("feedback_date"))
            .user(usersService.getUserById(resultSet.getLong("account_id")).get())
                .build();

    //language=sql
    private static final String SQL_SAVE_FEEDBACK = "insert into feedback (text, feedback_date, account_id)" +
            " values (?, ?, ?)";

    //language=sql
    private static final String SQL_SELECT_ALL_FEEDBACKS = "select * from feedback";






    public FeedbacksRepositoryJdbcImpl(MyDataSource dataSource, UsersService usersService) {
        template = new SimpleJdbcTemplate(dataSource);
        this.usersService = usersService;
    }







    @Override
    public List<Feedback> findAll() {
        return template.selectQuery(SQL_SELECT_ALL_FEEDBACKS, feedbackRowMapper);
    }

    @Override
    public Optional<Feedback> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Feedback feedback) {
        template.update(SQL_SAVE_FEEDBACK, feedback.getText(), feedback.getDate(), feedback.getUser().getId());
    }

    @Override
    public void update(Feedback entity) {

    }

    @Override
    public void delete(Feedback entity) {

    }
}
