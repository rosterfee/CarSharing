package ru.itis.javalab.repositories;

import ru.itis.javalab.models.User;
import ru.itis.javalab.utils.MyDataSource;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {

    MyDataSource dataSource;
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

    //language=sql
    private static final String SQL_SELECT_USER_BY_LOGIN = "select * from account where login = ?";

    //language=sql
    private static final String SQL_INSERT_AVATAR_TO_USER = "update account set avatar = ? where login = ?";

    //language=sql
    private static final String SQL_SELECT_AVATAR_BY_LOGIN = "select avatar from account where login = ?";








    public UsersRepositoryJdbcImpl(MyDataSource dataSource) {
        this.dataSource = dataSource;
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
    public Optional<User> findUserByLogin(String login) {
        User user = template.queryForObject(SQL_SELECT_USER_BY_LOGIN, userRowMapper, login);
        return Optional.ofNullable(user);
    }

    @Override
    public void uploadAvatar(InputStream inputStream, String login) {
        template.uploadImage(inputStream, SQL_INSERT_AVATAR_TO_USER, login);
    }

    @Override
    public Optional<String> getAvatarByLogin(String login) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String content = null;

        try {

            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_AVATAR_BY_LOGIN);
            preparedStatement.setObject(1, login);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                if (resultSet.getObject("avatar") != null) {
                    content = "data:image/png;base64," +
                            Base64.getEncoder().encodeToString(resultSet.getBytes("avatar"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ignore) { }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ignore) { }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ignore) { }
            }
        }

        return Optional.ofNullable(content);
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
