package ru.ketbiev.hov.model;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class Space {
    private long id;
    private String title;
    private OffsetDateTime createTime;
    private OffsetDateTime lastUpdate;
    private List<Note> notes;
    private List<Task> tasks;
    private List<Account> accounts;
    private int hostId;
    private List<Integer> participantIds;
}
