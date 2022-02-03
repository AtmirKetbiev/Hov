package ru.ketbiev.hov.core.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Task {
    private long id;
    private String title;
    private Map<String, Boolean> pointMap = new HashMap<>();
    private long spaceId;

    public void addPointMap(String text, Boolean done) {
        pointMap.put(text, done);
    }
}
