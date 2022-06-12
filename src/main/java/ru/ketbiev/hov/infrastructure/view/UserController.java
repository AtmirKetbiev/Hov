package ru.ketbiev.hov.infrastructure.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.ketbiev.hov.core.model.User;
import ru.ketbiev.hov.core.usecase.service.UserService;

import javax.validation.Valid;
import java.time.OffsetDateTime;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin/user")
    public String showUserList(Model model, User user) {
        model.addAttribute("users", userService.getAll());
        return "admin/user";
    }

    @GetMapping("/admin/signup")
    public String showSignUpForm(User user) {
        return "admin/user-add";
    }

    @PostMapping("/admin/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "admin/user-add";
        }
        user.setCreateDate(OffsetDateTime.now());
        user.setLastLoginDate(OffsetDateTime.now());
        userService.add(user);
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userService.get(id);
        model.addAttribute("user", user);

        return "admin/user-update";
    }

    @PostMapping("/admin/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "admin/user-update";
        }

        userService.update(user);

        return "redirect:/admin/user";
    }

    @GetMapping("/admin/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        userService.delete(id);

        return "redirect:/admin/user";
    }
}
