package ru.ketbiev.hov.repository.simplelist;

import ru.ketbiev.hov.model.Task;
import ru.ketbiev.hov.repository.TaskRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskListRepository implements TaskRepository {
    private List<Task> tasks = new ArrayList<>();

    @Override
    public Task add(Task task) {
        return null;
    }

    @Override
    public Task get(int id) {
        return null;
    }

    @Override
    public boolean update(Task task) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    private long getId() {
        return tasks.stream()
                .map(Task::getId)
                .max(Comparator.naturalOrder())
                .orElse(1L);
    }
}
