package ru.ketbiev.hov.infrastructure.repository.postgres.jdbc;

import ru.ketbiev.hov.core.model.Note;
import ru.ketbiev.hov.core.port.repository.NoteRepository;

import java.util.List;

public class NoteJdbcRepository implements NoteRepository {
    @Override
    public Note add(Note note) {
        return null;
    }

    @Override
    public Note get(long id) {
        return null;
    }

    @Override
    public boolean update(Note note) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public List<Note> findBySpaceId(long spaceId) {
        return null;
    }

    @Override
    public List<Long> findIdBySpaceId(long userId) {
        return null;
    }
}
