package ru.ketbiev.hov.infrastructure.rest.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ketbiev.hov.core.model.Space;
import ru.ketbiev.hov.core.service.SpaceService;

@RestController
@RequestMapping("users/{user_id}/spaces")
public class SpaceController {

    @Autowired
    private SpaceService spaceService;

    @GetMapping("/{id}")
    public Space get(@PathVariable long user_id,
                     @PathVariable long id) {
        return spaceService.get(id);
    }

    @PostMapping
    public Space addNewNote(@PathVariable long user_id,
                            @RequestBody Space space) {
        space.setHostId(user_id);
        return spaceService.add(space);
    }

    @PutMapping
    public boolean updateNote(@PathVariable long user_id,
                              @RequestBody Space space) {
        space.setHostId(user_id);
        return spaceService.update(space);
    }

    @DeleteMapping("/{id}")
    public boolean deleteNote(@PathVariable long user_id,
                              @PathVariable long id) {
        return spaceService.delete(id);
    }

}
