package ru.ketbiev.hov.repository;

import ru.ketbiev.hov.model.Space;

import java.util.List;

public interface SpaceRepository {
    Space add(Space space);

    Space get(long id);

    boolean update(Space space);

    boolean delete(long id);

    List<Space> findByUserId(long userId);
}
