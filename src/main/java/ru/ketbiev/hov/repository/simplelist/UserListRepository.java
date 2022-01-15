package ru.ketbiev.hov.repository.simplelist;

import ru.ketbiev.hov.model.User;
import ru.ketbiev.hov.repository.UserRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserListRepository implements UserRepository {
    private List<User> users = new ArrayList<>();

    @Override
    public User add(User user) {
        return null;
    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    private long getId() {
        return users.stream()
                .map(User::getId)
                .max(Comparator.naturalOrder())
                .orElse(1L);
    }
}
