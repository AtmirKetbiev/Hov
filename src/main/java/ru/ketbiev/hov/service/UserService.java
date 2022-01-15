package ru.ketbiev.hov.service;

import ru.ketbiev.hov.model.User;
import ru.ketbiev.hov.repository.UserRepository;

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
}
