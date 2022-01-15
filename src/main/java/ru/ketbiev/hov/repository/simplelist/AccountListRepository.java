package ru.ketbiev.hov.repository.simplelist;

import ru.ketbiev.hov.model.Account;
import ru.ketbiev.hov.repository.AccountRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AccountListRepository implements AccountRepository {
    private List<Account> accounts = new ArrayList<>();

    @Override
    public Account add(Account account) {
        return null;
    }

    @Override
    public Account get(int id) {
        return null;
    }

    @Override
    public boolean update(Account account) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    private long getId() {
        return accounts.stream()
                .map(Account::getId)
                .max(Comparator.naturalOrder())
                .orElse(1L);
    }
}
