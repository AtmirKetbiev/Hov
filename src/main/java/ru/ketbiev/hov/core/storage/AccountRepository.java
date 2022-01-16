package ru.ketbiev.hov.core.storage;

import ru.ketbiev.hov.core.model.Account;

import java.util.List;

public interface AccountRepository {
    Account add(Account account);

    Account get(long id);

    boolean update(Account account);

    boolean delete(long id);

    List<Account> findBySpaceId(long spaceId);
}
