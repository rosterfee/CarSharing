package ru.itis.javalab.repositories;

import ru.itis.javalab.models.User;

import java.io.InputStream;
import java.util.Optional;

public interface UsersRepository extends CrudRepository<User> {

    @Override
    void save(User user);

    Optional<User> findSuchUserForRegistration(User entity);

    Optional<User> findSuchUserForSignIn(String login, String password);

    Optional<User> findUserById(long id);

    void uploadAvatar(InputStream inputStream, String login);
}
