package ru.ketbiev.hov.core.port.repository;

import ru.ketbiev.hov.core.model.User;

import java.util.List;

public interface UserRepository {
    User add(User user);
    User get(long id);
    List<User> getAll();
    boolean update(User user);
    boolean delete(long id);
}
