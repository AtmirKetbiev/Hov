package ru.ketbiev.hov.repository;

import ru.ketbiev.hov.model.Task;

import java.util.List;

public interface TaskRepository {
    Task add(Task task);

    Task get(long id);

    boolean update(Task task);

    boolean delete(long id);

    List<Task> findBySpaceId(long spaceId);
}
