package ru.ketbiev.hov.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.ketbiev.hov.core.service.*;
import ru.ketbiev.hov.infraestructure.repository.simplmap.*;

@Configuration
public class Config {

    @Bean
    public AccountService createAccountService() {
        return new AccountService(new AccountMapRepository());
    }

    @Bean
    public NoteService createNoteService() {
        return new NoteService(new NoteMapRepository());
    }

    @Bean
    public SpaceService createSpaceService() {
        return new SpaceService(new SpaceMapRepository());
    }

    @Bean
    public TaskService createTaskService() {
        return new TaskService(new TaskMapRepository());
    }

    @Bean
    public UserService createUserService() {
        return new UserService(new UserMapRepository());
    }


}
