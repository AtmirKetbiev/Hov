package ru.ketbiev.hov.model;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class User {
    private long id;
    private String login;
    private String password;
    private OffsetDateTime createDate;
    private OffsetDateTime lastLoginDate;
    private List<Space> spaces;
}
