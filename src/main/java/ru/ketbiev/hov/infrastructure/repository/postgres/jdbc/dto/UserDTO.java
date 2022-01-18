package ru.ketbiev.hov.infrastructure.repository.postgres.jdbc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
public class UserDTO {
    private long id;
    private String login;
    private String password;
    private OffsetDateTime createDate;
    private OffsetDateTime lastLoginDate;
}
