package ru.ketbiev.hov.infrastructure.repository.simplmap;

import ru.ketbiev.hov.core.model.Task;
import ru.ketbiev.hov.core.port.repository.TaskRepository;

import java.util.*;

public class TaskMapRepository implements TaskRepository {
    private Map<Long, Task> tasks = new HashMap<>();

    @Override
    public Task add(Task task) {
        task.setId(getId());
        tasks.put(task.getId(), task);
        return tasks.get(task.getId());
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

    @Override
    public List<Long> findIdBySpaceId(long userId) {
        return tasks.values().stream()
                .filter(space -> space.getSpaceId() == userId)
                .map(Task::getId)
                .toList();
    }

    private long getId() {
        return tasks.keySet().stream()
                .max(Comparator.naturalOrder())
                .orElse(0L) + 1;
    }
}
