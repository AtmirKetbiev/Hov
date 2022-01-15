package ru.ketbiev.hov.service;

import ru.ketbiev.hov.model.Task;
import ru.ketbiev.hov.repository.TaskRepository;

public class TaskService implements CrudService<Task>{
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task add(Task task) {
        return taskRepository.add(task);
    }

    @Override
    public Task get(long id) {
        return taskRepository.get(id);
    }

    @Override
    public boolean update(Task task) {
        return taskRepository.update(task);
    }

    @Override
    public boolean delete(long id) {
        return taskRepository.delete(id);
    }
}
