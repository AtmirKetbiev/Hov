package ru.ketbiev.hov.service;

import ru.ketbiev.hov.model.Space;
import ru.ketbiev.hov.repository.SpaceRepository;

public class SpaceService implements CrudService<Space> {
    private SpaceRepository spaceRepository;

    public SpaceService(SpaceRepository spaceRepository) {
        this.spaceRepository = spaceRepository;
    }

    @Override
    public Space add(Space space) {
        return spaceRepository.add(space);
    }

    @Override
    public Space get(long id) {
        return spaceRepository.get(id);
    }

    @Override
    public boolean update(Space space) {
        return spaceRepository.update(space);
    }

    @Override
    public boolean delete(long id) {
        return spaceRepository.delete(id);
    }
}
