package ru.ketbiev.hov.repository;

import ru.ketbiev.hov.model.Account;

public interface AccountRepository {
    Account add(Account account);
    Account get(long id);
    boolean update(Account account);
    boolean delete(long id);
}
