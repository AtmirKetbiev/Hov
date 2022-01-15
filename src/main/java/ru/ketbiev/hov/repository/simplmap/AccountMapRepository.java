package ru.ketbiev.hov.repository.simplmap;

import ru.ketbiev.hov.model.Account;
import ru.ketbiev.hov.repository.AccountRepository;

import java.util.*;

public class AccountMapRepository implements AccountRepository {
    private Map<Long, Account> accounts = new HashMap<>();

    @Override
    public Account add(Account account) {
        return accounts.put(getId(), account);
    }

    @Override
    public Account get(long id) {
        return accounts.get(id);
    }

    @Override
    public boolean update(Account account) {
        accounts.put(account.getId(), account);
        return true;
    }

    @Override
    public boolean delete(long id) {
        accounts.remove(id);
        return true;
    }

    private long getId() {
        return accounts.keySet().stream()
                .max(Comparator.naturalOrder())
                .orElse(1L);
    }
}