package ru.ketbiev.hov.model;

import lombok.Data;

@Data
public class Note {
    private long id;
    private String title;
    private String text;
    private int spaceId;
}
