package ru.ketbiev.hov.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.ketbiev.hov.core.port.repository.*;
import ru.ketbiev.hov.core.usecase.service.*;
import ru.ketbiev.hov.infrastructure.repository.simplmap.*;

@Configuration
public class RepositoryConfig {

    AccountRepository accountRepository = new AccountMapRepository();
    NoteRepository noteRepository = new NoteMapRepository();
    TaskRepository taskRepository = new TaskMapRepository();
    SpaceRepository spaceRepository = new SpaceMapRepository(accountRepository, noteRepository, taskRepository);
    UserRepository userRepository = new UserMapRepository(spaceRepository);

    @Bean
    public AccountService createAccountService() {
        return new AccountService(accountRepository);
    }

    @Bean
    public NoteService createNoteService() {
        return new NoteService(noteRepository);
    }

    @Bean
    public TaskService createTaskService() {
        return new TaskService(taskRepository);
    }

    @Bean
    public SpaceService createSpaceService() {
        return new SpaceService(spaceRepository);
    }

    @Bean
    public UserService createUserService() {
        return new UserService(userRepository);
    }
}
