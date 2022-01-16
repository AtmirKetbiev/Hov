package ru.ketbiev.hov.infrastructure.rest.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ketbiev.hov.core.model.Note;
import ru.ketbiev.hov.core.service.NoteService;

@RestController
@RequestMapping("note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/{id}")
    public Note get(@PathVariable int id) {
        return noteService.get(id);
    }

    @PostMapping
    public Note addNewNote(@RequestBody Note note) {
        return noteService.add(note);
    }

    @PutMapping
    public boolean updateNote(@RequestBody Note note) {
        return noteService.update(note);
    }

    @DeleteMapping("/{id}")
    public boolean deleteNote(@PathVariable int id) {
        return noteService.delete(id);
    }

}
