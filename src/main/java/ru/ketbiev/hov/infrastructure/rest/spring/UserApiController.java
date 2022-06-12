package ru.ketbiev.hov.infrastructure.rest.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ketbiev.hov.core.model.User;
import ru.ketbiev.hov.core.usecase.service.UserService;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("api/users")
public class UserApiController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User get(@PathVariable long id) {
        return userService.get(id);
    }

    @PostMapping
    public User addNewUser(@RequestBody User user) {
        user.setCreateDate(OffsetDateTime.now());
        user.setLastLoginDate(OffsetDateTime.now());
        return userService.add(user);
    }

    @PutMapping
    public boolean updateEmployee (@RequestBody User user) {
        user.setLastLoginDate(OffsetDateTime.now());
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public boolean deleteEmployees(@PathVariable long id) {
        return userService.delete(id);
    }

}
