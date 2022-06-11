package ru.ketbiev.hov.infrastructure.repository.simplmap;

import org.junit.jupiter.api.Test;
import ru.ketbiev.hov.core.model.User;
import ru.ketbiev.hov.core.port.repository.UserRepository;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserMapRepositoryTest {

    @Test
    void add() {
        User user = new User();
        user.setLogin("Test User");
        user.setPassword("qwerty");
        user.setCreateDate(OffsetDateTime.now());
        user.setLastLoginDate(user.getCreateDate());
    }

    @Test
    void get() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}