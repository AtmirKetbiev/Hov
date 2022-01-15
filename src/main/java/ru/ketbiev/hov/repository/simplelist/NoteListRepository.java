package ru.ketbiev.hov.repository.simplelist;

import ru.ketbiev.hov.model.Note;
import ru.ketbiev.hov.repository.NoteRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NoteListRepository implements NoteRepository {
    private List<Note> notes = new ArrayList<>();

    @Override
    public Note add(Note note) {
        return null;
    }

    @Override
    public Note get(int id) {
        return null;
    }

    @Override
    public boolean update(Note note) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    private long getId() {
        return notes.stream()
                .map(Note::getId)
                .max(Comparator.naturalOrder())
                .orElse(1L);
    }
}
