package ru.itis.javalab.repositories;

import ru.itis.javalab.models.User;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.Optional;

public interface UsersRepository extends CrudRepository<User> {

    @Override
    void save(User user);

    Optional<User> findSuchUserForRegistration(User entity);

    Optional<User> findSuchUserForSignIn(String login, String password);

    Optional<User> findUserByLogin(String login);

    void uploadAvatar(InputStream inputStream, String login);

    Optional<String> getAvatarByLogin(String login);
}
