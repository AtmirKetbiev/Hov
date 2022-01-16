package ru.ketbiev.hov.infrastructure.rest.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ketbiev.hov.core.model.User;
import ru.ketbiev.hov.core.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User get(@PathVariable int id) {
        return userService.get(id);
    }

    @PostMapping
    public User addNewUser(@RequestBody User user) {
        return userService.add(user);
    }

    @PutMapping
    public boolean updateEmployee (@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public boolean deleteEmployees(@PathVariable int id) {
        return userService.delete(id);
    }

}
