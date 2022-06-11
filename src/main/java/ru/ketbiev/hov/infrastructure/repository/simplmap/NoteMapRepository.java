package ru.ketbiev.hov.infrastructure.repository.simplmap;

import ru.ketbiev.hov.core.model.Note;
import ru.ketbiev.hov.core.port.repository.NoteRepository;

import java.util.*;

public class NoteMapRepository implements NoteRepository {
    private Map<Long, Note> notes = new HashMap<>();

    @Override
    public Note add(Note note) {
        note.setId(getId());
        notes.put(note.getId(), note);
        return notes.get(note.getId());
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

    @Override
    public List<Note> findBySpaceId(long spaceId) {
        return notes.values().stream()
                .filter(account -> account.getSpaceId() == spaceId)
                .toList();
    }

    @Override
    public List<Long> findIdBySpaceId(long userId) {
        return notes.values().stream()
                .filter(space -> space.getSpaceId() == userId)
                .map(Note::getId)
                .toList();
    }

    private long getId() {
        return notes.keySet().stream()
                .max(Comparator.naturalOrder())
                .orElse(0L) + 1;
    }
}
