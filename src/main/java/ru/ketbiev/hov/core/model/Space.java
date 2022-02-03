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
public class Space {
    private long id;
    private String title;
    private OffsetDateTime createTime;
    private OffsetDateTime lastUpdate;
    private List<Note> notes = new ArrayList<>();
    private List<Task> tasks = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
    private long hostId;
    private List<Long> participantIds = new ArrayList<>();
}
