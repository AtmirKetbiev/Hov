package ru.ketbiev.hov.infrastructure.rest.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.ketbiev.hov.core.usecase.service.*;

@RequestMapping("api/main")
public class MainApiController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private NoteService noteService;

    @Autowired
    private SpaceService spaceService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping()
    public String get() {
        return "null";
    }

}
