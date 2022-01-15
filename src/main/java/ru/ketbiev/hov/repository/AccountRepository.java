package ru.ketbiev.hov.repository;

import ru.ketbiev.hov.model.Account;

import java.util.List;

public interface AccountRepository {
    Account add(Account account);

    Account get(long id);

    boolean update(Account account);

    boolean delete(long id);

    List<Account> findBySpaceId(long spaceId);
}
