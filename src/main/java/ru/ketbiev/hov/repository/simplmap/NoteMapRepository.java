package ru.ketbiev.hov.repository.simplmap;

import ru.ketbiev.hov.model.Note;
import ru.ketbiev.hov.repository.NoteRepository;

import java.util.*;

public class NoteMapRepository implements NoteRepository {
    private Map<Long, Note> notes = new HashMap<>();

    @Override
    public Note add(Note note) {
        return notes.put(getId(), note);
    }

    @Override
    public Note get(long id) {
        return notes.get(id);
    }

    @Override
    public boolean update(Note note) {
        notes.put(note.getId(), note);
        return true;
    }

    @Override
    public boolean delete(long id) {
        notes.remove(id);
        return true;
    }

    private long getId() {
        return notes.keySet().stream()
                .max(Comparator.naturalOrder())
                .orElse(1L);
    }
}
