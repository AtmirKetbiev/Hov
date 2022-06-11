package ru.ketbiev.hov.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    private long id;
    private String title;
    private String text;
    private long spaceId;
}
