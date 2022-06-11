package ru.ketbiev.hov.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private long id;
    private String title;
    private Boolean done;
    private OffsetDateTime taskDate;
    private long spaceId;
}
