package ru.ketbiev.hov.infrastructure.repository.simplmap;

import ru.ketbiev.hov.core.model.User;
import ru.ketbiev.hov.core.port.repository.UserRepository;

import java.util.*;

public class UserMapRepository implements UserRepository {
    private Map<Long, User> users = new HashMap<>();

    @Override
    public User add(User user) {
        user.setId(getId());
        users.put(user.getId(), user);
        return users.get(user.getId());
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
                .orElse(0L) + 1;
    }
}
