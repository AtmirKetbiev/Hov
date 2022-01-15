package ru.ketbiev.hov.model;

import lombok.Data;

@Data
public class Account {
    private int id;
    private String title;
    private String password;
    private String url;
    private String text;
    private int spaceId;
}
