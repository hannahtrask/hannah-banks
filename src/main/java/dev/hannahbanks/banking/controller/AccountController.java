package dev.hannahbanks.banking.controller;

import dev.hannahbanks.banking.dto.AccountDto;
import dev.hannahbanks.banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // add account REST API
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }


    // get single account REST API
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    // put new account balance REST API
    @PutMapping("/{id}/update")
    public ResponseEntity<AccountDto> updateAccountBalance(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        AccountDto accountDto = accountService.updateAccountBalance(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    // get all accounts REST API
//    @GetMapping
//    public ResponseEntity<List<Account>> getAllAccounts() {
//        List<Account> accounts = (List<Account>) accountService.getAllAccounts();
//        return ResponseEntity.ok(accounts);
//    }
}
