package ru.ketbiev.hov.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Space {
    private long id;
    private String title;
    private OffsetDateTime createTime;
    private OffsetDateTime lastUpdate;
    private List<Note> notes;
    private List<Task> tasks;
    private List<Account> accounts;
    private long hostId;
    private List<Long> participantIds;
}
