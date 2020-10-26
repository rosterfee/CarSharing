package ru.itis.javalab.services;

import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<User> getUserByLoginAndPassword(String login, String password) {
        return usersRepository.findUserByLoginAndPassword(login, password);
    }

    @Override
    public void saveUser(User entity) {
        usersRepository.save(entity);
    }

    @Override
    public Optional<User> getSuchUser(User entity) {
        return usersRepository.findSuchUser(entity);
    }
}
