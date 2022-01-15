package ru.ketbiev.hov.repository.simplelist;

import ru.ketbiev.hov.model.Space;
import ru.ketbiev.hov.repository.SpaceRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SpaceListRepository implements SpaceRepository {
    private List<Space> spaces = new ArrayList<>();

    @Override
    public Space add(Space space) {
        return null;
    }

    @Override
    public Space get(int id) {
        return null;
    }

    @Override
    public boolean update(Space space) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    private long getId() {
        return spaces.stream()
                .map(Space::getId)
                .max(Comparator.naturalOrder())
                .orElse(1L);
    }
}
