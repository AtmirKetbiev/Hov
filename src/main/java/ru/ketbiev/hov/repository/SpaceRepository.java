package ru.ketbiev.hov.repository;

import ru.ketbiev.hov.model.Space;

public interface SpaceRepository {
    Space add(Space space);
    Space get(long id);
    boolean update(Space space);
    boolean delete(long id);
}
