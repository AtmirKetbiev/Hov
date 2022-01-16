package ru.ketbiev.hov.repository.simplmap;

import ru.ketbiev.hov.core.model.User;
import ru.ketbiev.hov.core.storage.UserRepository;

import java.util.*;

public class UserMapRepository implements UserRepository {
    private Map<Long, User> users = new HashMap<>();

    @Override
    public User add(User user) {
        return users.put(getId(), user);
    }

    @Override
    public User get(long id) {
        return users.get(id);
    }

    @Override
    public boolean update(User user) {
        users.put(user.getId(), user);
        return true;
    }

    @Override
    public boolean delete(long id) {
        users.remove(id);
        return true;
    }

    private long getId() {
        return users.keySet().stream()
                .max(Comparator.naturalOrder())
                .orElse(1L);
    }
}
