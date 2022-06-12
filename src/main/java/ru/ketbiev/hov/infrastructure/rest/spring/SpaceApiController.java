package ru.ketbiev.hov.infrastructure.rest.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ketbiev.hov.core.model.Space;
import ru.ketbiev.hov.core.usecase.service.SpaceService;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("api/users/{user_id}/spaces")
public class SpaceApiController {

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
        space.setCreateTime(OffsetDateTime.now());
        space.setLastUpdate(OffsetDateTime.now());
        return spaceService.add(space);
    }

    @PutMapping
    public boolean updateNote(@PathVariable long user_id,
                              @RequestBody Space space) {
        space.setHostId(user_id);
        space.setLastUpdate(OffsetDateTime.now());
        return spaceService.update(space);
    }

    @DeleteMapping("/{id}")
    public boolean deleteNote(@PathVariable long user_id,
                              @PathVariable long id) {
        return spaceService.delete(id);
    }

}
