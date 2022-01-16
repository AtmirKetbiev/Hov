package ru.ketbiev.hov.core.storage;

import ru.ketbiev.hov.core.model.User;

public interface UserRepository {
    User add(User user);

    User get(long id);

    boolean update(User user);

    boolean delete(long id);
}
