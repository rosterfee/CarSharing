package ru.itis.javalab.repositories;

import ru.itis.javalab.models.User;

import java.util.Optional;

public interface UsersRepository extends CrudRepository<User> {

    public Optional<User> findUserByLoginAndPassword(String login, String password);

    @Override
    void save(User user);

    Optional<User> findSuchUser(User entity);
}
