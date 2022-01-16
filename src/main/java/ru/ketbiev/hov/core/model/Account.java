package ru.ketbiev.hov.core.model;

import lombok.Data;

@Data
public class Account {
    private long id;
    private String title;
    private String password;
    private String url;
    private String text;
    private long spaceId;
}
