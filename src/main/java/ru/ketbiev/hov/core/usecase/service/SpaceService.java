package ru.ketbiev.hov.core.usecase.service;

import ru.ketbiev.hov.core.model.Space;
import ru.ketbiev.hov.core.port.repository.SpaceRepository;

import java.util.List;

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

    public List<Space> getAllByUserId(long id) {
        return spaceRepository.findByUserId(id);
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
