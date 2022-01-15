package ru.ketbiev.hov.repository;

import ru.ketbiev.hov.model.Space;

public interface SpaceRepository {
    public Space add(Space space);
    public Space get(int id);
    public boolean update(Space space);
    public boolean delete(int id);
}
