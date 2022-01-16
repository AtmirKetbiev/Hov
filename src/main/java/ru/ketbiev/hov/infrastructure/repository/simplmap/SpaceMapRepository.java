package ru.ketbiev.hov.infrastructure.repository.simplmap;

import ru.ketbiev.hov.core.model.Space;
import ru.ketbiev.hov.core.port.repository.SpaceRepository;

import java.util.*;

public class SpaceMapRepository implements SpaceRepository {
    private Map<Long, Space> spaces = new HashMap<>();

    @Override
    public Space add(Space space) {
        space.setId(getId());
        spaces.put(space.getId(), space);
        return spaces.get(space.getId());
    }

    @Override
    public Space get(long id) {
        return spaces.get(id);
    }

    @Override
    public boolean update(Space space) {
        spaces.put(space.getId(), space);
        return true;
    }

    @Override
    public boolean delete(long id) {
        spaces.remove(id);
        return true;
    }

    @Override
    public List<Space> findByUserId(long userId) {
        return spaces.values().stream()
                .filter(space -> space.getHostId() == userId
                        || space.getParticipantIds().contains(userId))
                .toList();
    }

    private long getId() {
        return spaces.keySet().stream()
                .max(Comparator.naturalOrder())
                .orElse(0L) + 1;
    }
}
