package ru.ketbiev.hov.infrastructure.repository.postgres.jdbc;

import ru.ketbiev.hov.core.model.Account;
import ru.ketbiev.hov.core.port.repository.AccountRepository;

import java.util.List;

public class AccountJdbcRepository implements AccountRepository {
    @Override
    public Account add(Account account) {
        return null;
    }

    @Override
    public Account get(long id) {
        return null;
    }

    @Override
    public boolean update(Account account) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public List<Account> findBySpaceId(long spaceId) {
        return null;
    }

    @Override
    public List<Long> findIdBySpaceId(long userId) {
        return null;
    }
}
