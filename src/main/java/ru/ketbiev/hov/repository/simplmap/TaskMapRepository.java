package ru.ketbiev.hov.repository.simplmap;

import ru.ketbiev.hov.model.Note;
import ru.ketbiev.hov.model.Task;
import ru.ketbiev.hov.repository.TaskRepository;

import java.util.*;

public class TaskMapRepository implements TaskRepository {
    private Map<Long, Task> tasks = new HashMap<>();

    @Override
    public Task add(Task task) {
        return tasks.put(getId(), task);
    }

    @Override
    public Task get(long id) {
        return tasks.get(id);
    }

    @Override
    public boolean update(Task task) {
        tasks.put(task.getId(), task);
        return true;
    }

    @Override
    public boolean delete(long id) {
        tasks.remove(id);
        return true;
    }

    @Override
    public List<Task> findBySpaceId(long spaceId) {
        return tasks.values().stream()
                .filter(account -> account.getSpaceId() == spaceId)
                .toList();
    }

    private long getId() {
        return tasks.keySet().stream()
                .max(Comparator.naturalOrder())
                .orElse(1L);
    }
}
