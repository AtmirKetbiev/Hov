package ru.ketbiev.hov.core.port.repository;

import ru.ketbiev.hov.core.model.Space;

import java.util.List;

public interface SpaceRepository {
    Space add(Space space);

    Space get(long id);

    boolean update(Space space);

    boolean delete(long id);

    List<Space> getAllByUserId(long userId);
}
