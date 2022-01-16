package ru.ketbiev.hov.core.model;

import lombok.Data;

@Data
public class Note {
    private long id;
    private String title;
    private String text;
    private long spaceId;
}
