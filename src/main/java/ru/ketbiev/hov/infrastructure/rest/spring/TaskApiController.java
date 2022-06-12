package ru.ketbiev.hov.infrastructure.rest.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ketbiev.hov.core.model.Task;
import ru.ketbiev.hov.core.usecase.service.TaskService;

@RestController
@RequestMapping("api/users/{user_id}/spaces/{spaces_id}/tasks")
public class TaskApiController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}")
    public Task get(@PathVariable long user_id,
                    @PathVariable long spaces_id,
                    @PathVariable long id) {
        return taskService.get(id);
    }

    @PostMapping
    public Task addNewNote(@PathVariable long user_id,
                           @PathVariable long spaces_id,
                           @RequestBody Task task) {
        task.setSpaceId(spaces_id);
        return taskService.add(task);
    }

    @PutMapping
    public boolean updateNote(@PathVariable long user_id,
                              @PathVariable long spaces_id,
                              @RequestBody Task task) {
        task.setSpaceId(spaces_id);
        return taskService.update(task);
    }

    @DeleteMapping("/{id}")
    public boolean deleteNote(@PathVariable long user_id,
                              @PathVariable long spaces_id,
                              @PathVariable long id) {
        return taskService.delete(id);
    }

}
