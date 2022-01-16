package ru.ketbiev.hov.infrastructure.rest.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ketbiev.hov.core.model.Space;
import ru.ketbiev.hov.core.service.SpaceService;

@RestController
@RequestMapping("space")
public class SpaceController {

    @Autowired
    private SpaceService spaceService;

    @GetMapping("/{id}")
    public Space get(@PathVariable int id) {
        return spaceService.get(id);
    }

    @PostMapping
    public Space addNewNote(@RequestBody Space space) {
        return spaceService.add(space);
    }

    @PutMapping
    public boolean updateNote(@RequestBody Space space) {
        return spaceService.update(space);
    }

    @DeleteMapping("/{id}")
    public boolean deleteNote(@PathVariable int id) {
        return spaceService.delete(id);
    }

}
