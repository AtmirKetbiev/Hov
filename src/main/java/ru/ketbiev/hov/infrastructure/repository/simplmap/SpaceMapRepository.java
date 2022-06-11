package ru.ketbiev.hov.infrastructure.repository.simplmap;

import ru.ketbiev.hov.core.model.Space;
import ru.ketbiev.hov.core.port.repository.AccountRepository;
import ru.ketbiev.hov.core.port.repository.NoteRepository;
import ru.ketbiev.hov.core.port.repository.SpaceRepository;
import ru.ketbiev.hov.core.port.repository.TaskRepository;

import java.util.*;

public class SpaceMapRepository implements SpaceRepository {
    private Map<Long, Space> spaces = new HashMap<>();

    AccountRepository accountRepository;
    NoteRepository noteRepository;
    TaskRepository taskRepository;

    public SpaceMapRepository(AccountRepository accountRepository,
                              NoteRepository noteRepository,
                              TaskRepository taskRepository) {
        this.accountRepository = accountRepository;
        this.noteRepository = noteRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public Space add(Space space) {
        space.setId(getId());
        spaces.put(space.getId(), space);
        return spaces.get(space.getId());
    }

    @Override
    public Space get(long id) {
        return spaces.get(id);
    }

    @Override
    public boolean update(Space space) {
        Space spaceOld = spaces.get(space.getId());
        if (space.getCreateTime() == null) {
            space.setCreateTime(spaceOld.getCreateTime());
        }
        spaces.put(space.getId(), space);
        return true;
    }

    @Override
    public boolean delete(long id) {
        accountRepository.findIdBySpaceId(id).forEach(accountId -> accountRepository.delete(accountId));
        noteRepository.findIdBySpaceId(id).forEach(noteId -> noteRepository.delete(noteId));
        taskRepository.findIdBySpaceId(id).forEach(taskId -> taskRepository.delete(taskId));
        spaces.remove(id);
        return true;
    }

    @Override
    public List<Space> findByUserId(long userId) {
        return spaces.values().stream()
                .filter(space -> space.getHostId() == userId)
                .toList();
    }

    @Override
    public List<Long> findIdByUserId(long userId) {
        return spaces.values().stream()
                .filter(space -> space.getHostId() == userId)
                .map(Space::getId)
                .toList();
    }

    private long getId() {
        return spaces.keySet().stream()
                .max(Comparator.naturalOrder())
                .orElse(0L) + 1;
    }
}
