package ru.ketbiev.hov.infrastructure.rest.spring;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ketbiev.hov.core.model.User;
import ru.ketbiev.hov.core.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User addNewUser(@RequestBody String data) {
        JSONObject userJson = new JSONObject(data);
        User user = new User();
        user.setLogin(userJson.getString("login"));
        user.setPassword(userJson.getString("password"));
        return userService.add(user);
    }

}
