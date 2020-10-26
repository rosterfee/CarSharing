package ru.itis.javalab.services;

import ru.itis.javalab.models.User;
import java.util.List;
import java.util.Optional;

public interface UsersService {

    List<User> getAllUsers();

    Optional<User> getUserByLoginAndPassword(String login, String password);

    void saveUser(User entity);

    Optional<User> getSuchUser(User entitu);
}
