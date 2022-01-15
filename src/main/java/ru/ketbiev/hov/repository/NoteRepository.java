package ru.ketbiev.hov.repository;

import ru.ketbiev.hov.model.Note;

public interface NoteRepository {
    public Note add(Note note);
    public Note get(int id);
    public boolean update(Note note);
    public boolean delete(int id);
}
