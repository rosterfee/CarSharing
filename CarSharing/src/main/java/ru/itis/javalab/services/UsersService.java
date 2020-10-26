package ru.itis.javalab.services;

import ru.itis.javalab.models.User;
import java.util.List;
import java.util.Optional;

public interface UsersService {

    List<User> getAllUsers();

    void saveUser(User entity);

    Optional<User> getSuchUserForRegistration(User entity);

    Optional<User> getSuchUserForSignIn(String login, String password);
}
