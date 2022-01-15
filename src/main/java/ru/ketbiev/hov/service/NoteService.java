package ru.ketbiev.hov.service;

import ru.ketbiev.hov.model.Note;
import ru.ketbiev.hov.repository.NoteRepository;

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
