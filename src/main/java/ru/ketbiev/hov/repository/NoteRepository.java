package ru.ketbiev.hov.repository;

import ru.ketbiev.hov.model.Note;

public interface NoteRepository {
    Note add(Note note);
    Note get(long id);
    boolean update(Note note);
    boolean delete(long id);
}
