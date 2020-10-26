package ru.itis.javalab.repositories;

import ru.itis.javalab.models.User;
import ru.itis.javalab.utils.MyDataSource;

import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {

    private SimpleJdbcTemplate template;

    private RowMapper<User> userRowMapper = resultSet -> User.builder()
            .firstName(resultSet.getString("first_name"))
            .lastName(resultSet.getString("last_name"))
            .phone(resultSet.getString("phone"))
            .login(resultSet.getString("login"))
            .email(resultSet.getString("email"))
            .password(resultSet.getString("password"))
            .build();

    //language=sql
    private static final String SQL_SELECT_SUCH_USER_FOR_SIGN_IN =
            "select * from account where login = ? and password = ?";

    //language=sql
    private static final String SQL_SAVE_NEW_USER =
            "insert into account (login, password, email, phone, first_name, last_name)" +
                    "values (?, ?, ?, ?, ?, ?)";

    //language=sql
    private static final String SQL_SELECT_SUCH_USER_FOR_REGISTRATION = "select * from account where login = ? or email = ? " +
            "or phone = ?";








    public UsersRepositoryJdbcImpl(MyDataSource dataSource) {
        template = new SimpleJdbcTemplate(dataSource);
    }







    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return null;
    }

    @Override
    public void save(User entity) {
        template.update(SQL_SAVE_NEW_USER, entity.getLogin(), entity.getPassword(), entity.getEmail(),
                entity.getPhone(), entity.getFirstName(), entity.getLastName());
    }

    @Override
    public Optional<User> findSuchUserForRegistration(User entity) {
        User user = template.queryForObject(SQL_SELECT_SUCH_USER_FOR_REGISTRATION, userRowMapper,
                entity.getLogin(), entity.getEmail(), entity.getPhone());
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findSuchUserForSignIn(String login, String password) {
        User user = template.queryForObject(SQL_SELECT_SUCH_USER_FOR_SIGN_IN, userRowMapper, login, password);
        return Optional.ofNullable(user);
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(User entity) {

    }

}
