package ru.ketbiev.hov.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Space {
    private long id;
    private String title;
    private OffsetDateTime createTime;
    private OffsetDateTime lastUpdate;
    private long hostId;
}
