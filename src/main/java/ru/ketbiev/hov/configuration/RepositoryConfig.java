package ru.ketbiev.hov.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.ketbiev.hov.core.port.repository.*;
import ru.ketbiev.hov.core.service.*;
import ru.ketbiev.hov.infrastructure.repository.simplmap.*;

@Configuration
public class RepositoryConfig {

    AccountRepository accountRepository = new AccountMapRepository();
    NoteRepository noteRepository = new NoteMapRepository();
    SpaceRepository spaceRepository = new SpaceMapRepository();
    TaskRepository taskRepository = new TaskMapRepository();
    UserRepository userRepository = new UserMapRepository();

    @Bean
    public AccountService createAccountService() {
        return new AccountService(accountRepository);
    }

    @Bean
    public NoteService createNoteService() {
        return new NoteService(noteRepository);
    }

    @Bean
    public SpaceService createSpaceService() {
        return new SpaceService(spaceRepository);
    }

    @Bean
    public TaskService createTaskService() {
        return new TaskService(taskRepository);
    }

    @Bean
    public UserService createUserService() {
        return new UserService(userRepository);
    }



}
