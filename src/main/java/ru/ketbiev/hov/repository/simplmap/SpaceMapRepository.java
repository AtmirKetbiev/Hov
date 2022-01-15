package ru.ketbiev.hov.repository.simplmap;

import ru.ketbiev.hov.model.Space;
import ru.ketbiev.hov.repository.SpaceRepository;

import java.util.*;

public class SpaceMapRepository implements SpaceRepository {
    private Map<Long, Space> spaces = new HashMap<>();

    @Override
    public Space add(Space space) {
        return spaces.put(getId(), space);
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

    private long getId() {
        return spaces.keySet().stream()
                .max(Comparator.naturalOrder())
                .orElse(1L);
    }
}
