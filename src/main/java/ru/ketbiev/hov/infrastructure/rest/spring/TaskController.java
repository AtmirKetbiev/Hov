package ru.ketbiev.hov.infrastructure.rest.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ketbiev.hov.core.model.Task;
import ru.ketbiev.hov.core.service.TaskService;

@RestController
@RequestMapping("task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}")
    public Task get(@PathVariable int id) {
        return taskService.get(id);
    }

    @PostMapping
    public Task addNewNote(@RequestBody Task task) {
        return taskService.add(task);
    }

    @PutMapping
    public boolean updateNote(@RequestBody Task task) {
        return taskService.update(task);
    }

    @DeleteMapping("/{id}")
    public boolean deleteNote(@PathVariable int id) {
        return taskService.delete(id);
    }

}
