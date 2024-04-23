package dev.hannahbanks.banking.service;

import dev.hannahbanks.banking.dto.AccountDto;

public interface AccountService {

    AccountDto createAccount(AccountDto account);
}
