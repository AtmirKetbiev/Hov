package ru.ketbiev.hov.core.service;

import ru.ketbiev.hov.core.model.Note;
import ru.ketbiev.hov.core.storage.NoteRepository;

public class NoteService implements CrudService<Note>{
    private NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note add(Note note) {
        return noteRepository.add(note);
    }

    @Override
    public Note get(long id) {
        return noteRepository.get(id);
    }

    @Override
    public boolean update(Note note) {
        return noteRepository.update(note);
    }

    @Override
    public boolean delete(long id) {
        return noteRepository.delete(id);
    }
}
