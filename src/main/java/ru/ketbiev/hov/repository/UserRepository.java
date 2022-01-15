package ru.ketbiev.hov.repository;

import ru.ketbiev.hov.model.User;

public interface UserRepository {
    User add(User user);
    User get(long id);
    boolean update(User user);
    boolean delete(long id);
}
