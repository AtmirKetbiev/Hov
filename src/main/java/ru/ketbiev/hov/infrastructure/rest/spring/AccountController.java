package ru.ketbiev.hov.infrastructure.rest.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ketbiev.hov.core.model.Account;
import ru.ketbiev.hov.core.service.AccountService;

@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{id}")
    public Account get(@PathVariable int id) {
        return accountService.get(id);
    }

    @PostMapping
    public Account addNewAccount(@RequestBody Account account) {
        return accountService.add(account);
    }

    @PutMapping
    public boolean updateAccount(@RequestBody Account account) {
        return accountService.update(account);
    }

    @DeleteMapping("/{id}")
    public boolean deleteAccount(@PathVariable int id) {
        return accountService.delete(id);
    }

}
