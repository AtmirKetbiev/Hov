package ru.ketbiev.hov.infrastructure.rest.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ketbiev.hov.core.model.Account;
import ru.ketbiev.hov.core.service.AccountService;

@RestController
@RequestMapping("users/{user_id}/spaces/{spaces_id}/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{id}")
    public Account get(@PathVariable long user_id,
                       @PathVariable long spaces_id,
                       @PathVariable long id) {
        return accountService.get(id);
    }

    @PostMapping
    public Account addNewAccount(@PathVariable long user_id,
                                 @PathVariable long spaces_id,
                                 @RequestBody Account account) {
        account.setSpaceId(spaces_id);
        return accountService.add(account);
    }

    @PutMapping
    public boolean updateAccount(@PathVariable long user_id,
                                 @PathVariable long spaces_id,
                                 @RequestBody Account account) {
        account.setSpaceId(spaces_id);
        return accountService.update(account);
    }

    @DeleteMapping("/{id}")
    public boolean deleteAccount(@PathVariable long user_id,
                                 @PathVariable long spaces_id,
                                 @PathVariable long id) {
        return accountService.delete(id);
    }

}
