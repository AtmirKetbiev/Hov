package ru.ketbiev.hov.infrastructure.repository.postgres.jdbc;

import ru.ketbiev.hov.core.model.Space;
import ru.ketbiev.hov.core.port.repository.SpaceRepository;

import java.util.List;

public class SpaceJdbcRepository implements SpaceRepository {
    @Override
    public Space add(Space space) {
        return null;
    }

    @Override
    public Space get(long id) {
        return null;
    }

    @Override
    public boolean update(Space space) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public List<Space> getAllByUserId(long userId) {
        return null;
    }
}
