package ru.ketbiev.hov.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private long id;
    private String login;
    private String password;
    private OffsetDateTime createDate;
    private OffsetDateTime lastLoginDate;
    private List<Space> spaces = new ArrayList<>();
}
