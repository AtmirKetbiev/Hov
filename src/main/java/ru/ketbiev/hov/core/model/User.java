package ru.ketbiev.hov.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private long id;
    private String login;
    private String password;
    private OffsetDateTime createDate;
    private OffsetDateTime lastLoginDate;
}
