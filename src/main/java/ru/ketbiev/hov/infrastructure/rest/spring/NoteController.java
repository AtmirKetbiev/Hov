package ru.ketbiev.hov.infrastructure.rest.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ketbiev.hov.core.model.Note;
import ru.ketbiev.hov.core.usecase.service.NoteService;

@RestController
@RequestMapping("users/{user_id}/spaces/{spaces_id}/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/{id}")
    public Note get(@PathVariable long user_id,
                    @PathVariable long spaces_id,
                    @PathVariable long id) {
        return noteService.get(id);
    }

    @PostMapping
    public Note addNewNote(@PathVariable long user_id,
                           @PathVariable long spaces_id,
                           @RequestBody Note note) {
        note.setSpaceId(spaces_id);
        return noteService.add(note);
    }

    @PutMapping
    public boolean updateNote(@PathVariable long user_id,
                              @PathVariable long spaces_id,
                              @RequestBody Note note) {
        note.setSpaceId(spaces_id);
        return noteService.update(note);
    }

    @DeleteMapping("/{id}")
    public boolean deleteNote(@PathVariable long user_id,
                              @PathVariable long spaces_id,
                              @PathVariable long id) {
        return noteService.delete(id);
    }

}
