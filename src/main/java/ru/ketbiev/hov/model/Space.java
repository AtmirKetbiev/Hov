package ru.ketbiev.hov.model;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class Space {
    private int id;
    private String title;
    private int hostId;
    private OffsetDateTime createTime;
    private OffsetDateTime lastUpdate;
    private List<Note> notes;
    private List<Task> tasks;
    private List<Account> accounts;
    private List<Integer> participantIds;
}
