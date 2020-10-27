package ru.itis.javalab.services;

import ru.itis.javalab.models.User;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public interface UsersService {

    List<User> getAllUsers();

    void saveUser(User entity);

    Optional<User> getSuchUserForRegistration(User entity);

    Optional<User> getSuchUserForSignIn(String login, String password);

    Optional<User> getUserByLogin(String login);

    void uploadAvatar(InputStream inputStream, String login);

    Optional<String> getAvatarByLogin(String login);
}
