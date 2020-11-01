package ru.itis.javalab.repositories;

import ru.itis.javalab.models.User;
import ru.itis.javalab.utils.MyDataSource;

import java.io.InputStream;
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
            .avatar(resultSet.getString("avatar"))
            .id(resultSet.getLong("id"))
            .city(resultSet.getString("city"))
            .build();





    //language=sql
    private static final String SQL_SELECT_SUCH_USER_FOR_SIGN_IN =
            "select * from account where login = ? and password = ?";

    //language=sql
    private static final String SQL_SAVE_NEW_USER =
            "insert into account (login, password, email, phone, first_name, last_name, avatar)" +
                    "values (?, ?, ?, ?, ?, ?, ?)";

    //language=sql
    private static final String SQL_SELECT_SUCH_USER_FOR_REGISTRATION = "select * from account where login = ? or email = ? " +
            "or phone = ?";

    //language=sql
    private static final String SQL_SELECT_USER_BY_ID = "select * from account where id = ?";

    //language=sql
    private static final String SQL_INSERT_AVATAR_TO_USER = "update account set avatar = ? where login = ?";

    //language=sql
    private static final String SQL_UPDATE_USER = "update account set first_name = ?, last_name = ?," +
            "email = ?, phone = ?, login = ?, password = ? where id = ?";

    //language=sql
    private static final String SQL_SET_USER_CITY = "update account set city = ? where id = ?";








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
                entity.getPhone(), entity.getFirstName(), entity.getLastName(), entity.getAvatar());
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
    public Optional<User> findUserById(long id) {
        User user = template.queryForObject(SQL_SELECT_USER_BY_ID, userRowMapper, id);
        return Optional.ofNullable(user);
    }

    @Override
    public void uploadAvatar(InputStream inputStream, String login) {
        template.uploadImage(inputStream, SQL_INSERT_AVATAR_TO_USER, login);
    }

    @Override
    public void setUserCity(String city, long id) {
        template.update(SQL_SET_USER_CITY, city, id);
    }


    @Override
    public void update(User entity) {
        template.update(SQL_UPDATE_USER, entity.getFirstName(), entity.getLastName(), entity.getEmail(),
                entity.getPhone(), entity.getLogin(), entity.getPassword(), entity.getId());
    }


    @Override
    public void delete(User entity) {

    }

}
