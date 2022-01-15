package ru.ketbiev.hov.repository;

import ru.ketbiev.hov.model.Task;

public interface TaskRepository {
    public Task add(Task task);
    public Task get(int id);
    public boolean update(Task task);
    public boolean delete(int id);
}
