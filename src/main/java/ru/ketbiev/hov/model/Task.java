package ru.ketbiev.hov.model;

import lombok.Data;

import java.util.Map;

@Data
public class Task {
    private int id;
    private String title;
    private Map<Integer, TaskPoint> pointMap;
}
