package ru.ketbiev.hov.infrastructure.repository.postgres.hibernate;

import ru.ketbiev.hov.core.model.User;
import ru.ketbiev.hov.infrastructure.repository.postgres.dto.UserDto;

public class DtoParser {
    public static User toUser(UserDto userDto) {
        return new User();
    }

    public static UserDto toUserDto(User user) {
        return new UserDto();
    }
}
