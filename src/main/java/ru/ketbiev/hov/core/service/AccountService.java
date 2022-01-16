package ru.ketbiev.hov.core.service;

import ru.ketbiev.hov.core.model.Account;
import ru.ketbiev.hov.core.port.repository.AccountRepository;

public class AccountService implements CrudService<Account> {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account add(Account account) {
        return accountRepository.add(account);
    }

    @Override
    public Account get(long id) {
        return accountRepository.get(id);
    }

    @Override
    public boolean update(Account account) {
        return accountRepository.update(account);
    }

    @Override
    public boolean delete(long id) {
        return accountRepository.delete(id);
    }
}
