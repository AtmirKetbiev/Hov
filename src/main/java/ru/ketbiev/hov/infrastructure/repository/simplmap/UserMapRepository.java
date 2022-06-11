package ru.ketbiev.hov.infrastructure.repository.simplmap;

import ru.ketbiev.hov.core.model.User;
import ru.ketbiev.hov.core.port.repository.SpaceRepository;
import ru.ketbiev.hov.core.port.repository.UserRepository;

import java.util.*;

public class UserMapRepository implements UserRepository {
    private Map<Long, User> users = new HashMap<>();

    SpaceRepository spaceRepository;

    public UserMapRepository(SpaceRepository spaceRepository) {
        this.spaceRepository = spaceRepository;
    }

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
        User userOld = users.get(user.getId());
        if (user.getCreateDate() == null) {
            user.setCreateDate(userOld.getCreateDate());
        }
        users.put(user.getId(), user);
        return true;
    }

    @Override
    public boolean delete(long id) {
        List<Long> spaces = spaceRepository.findIdByUserId(id);
        spaces.forEach(spaceId -> spaceRepository.delete(spaceId));
        users.remove(id);
        return true;
    }

    private long getId() {
        return users.keySet().stream()
                .max(Comparator.naturalOrder())
                .orElse(0L) + 1;
    }
}
