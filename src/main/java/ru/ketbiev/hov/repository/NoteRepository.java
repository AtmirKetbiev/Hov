package ru.ketbiev.hov.repository;

import ru.ketbiev.hov.model.Note;

import java.util.List;

public interface NoteRepository {
    Note add(Note note);

    Note get(long id);

    boolean update(Note note);

    boolean delete(long id);

    List<Note> findBySpaceId(long spaceId);
}
