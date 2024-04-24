package dev.hannahbanks.banking.service;

import dev.hannahbanks.banking.dto.AccountDto;

public interface AccountService {

    AccountDto createAccount(AccountDto account);

    AccountDto updateAccountBalance(Long id, double amount);

    AccountDto getAccountById(Long id);
}
