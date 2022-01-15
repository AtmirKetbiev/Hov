package ru.ketbiev.hov.model;

import lombok.Data;

import java.util.Map;

@Data
public class Task {
    private long id;
    private String title;
    private Map<String, Boolean> pointMap;
    private long spaceId;
}
