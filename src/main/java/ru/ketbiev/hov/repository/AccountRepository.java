package ru.ketbiev.hov.repository;

import ru.ketbiev.hov.model.Account;

public interface AccountRepository {
    public Account add(Account account);
    public Account get(int id);
    public boolean update(Account account);
    public boolean delete(int id);
}
