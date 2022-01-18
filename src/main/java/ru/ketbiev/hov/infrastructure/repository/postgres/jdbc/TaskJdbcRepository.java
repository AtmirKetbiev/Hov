package ru.ketbiev.hov.infrastructure.repository.postgres.jdbc;

import ru.ketbiev.hov.core.model.Task;
import ru.ketbiev.hov.core.port.repository.TaskRepository;

import java.util.List;

public class TaskJdbcRepository implements TaskRepository {
    @Override
    public Task add(Task task) {
        return null;
    }

    @Override
    public Task get(long id) {
        return null;
    }

    @Override
    public boolean update(Task task) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public List<Task> findBySpaceId(long spaceId) {
        return null;
    }
}
