package ru.ketbiev.hov.core.port.repository;

import ru.ketbiev.hov.core.model.Note;

import java.util.List;

public interface NoteRepository {
    Note add(Note note);
    Note get(long id);
    boolean update(Note note);
    boolean delete(long id);
    List<Note> findBySpaceId(long spaceId);
    List<Long> findIdBySpaceId(long userId);
}
