package ru.ketbiev.hov.repository;

import ru.ketbiev.hov.model.User;

public interface UserRepository {
    public User add(User user);
    public User get(int id);
    public boolean update(User user);
    public boolean delete(int id);
}
