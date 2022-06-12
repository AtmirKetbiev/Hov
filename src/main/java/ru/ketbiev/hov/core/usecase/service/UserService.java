package ru.ketbiev.hov.core.usecase.service;

import ru.ketbiev.hov.core.model.User;
import ru.ketbiev.hov.core.port.repository.UserRepository;

import java.util.List;

public class UserService implements CrudService<User> {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User add(User user) {
        return userRepository.add(user);
    }

    @Override
    public User get(long id) {
        return userRepository.get(id);
    }

    @Override
    public boolean update(User user) {
        return userRepository.update(user);
    }

    @Override
    public boolean delete(long id) {
        return userRepository.delete(id);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }
}
