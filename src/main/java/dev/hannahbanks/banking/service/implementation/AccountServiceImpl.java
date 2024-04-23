package dev.hannahbanks.banking.service.implementation;

import dev.hannahbanks.banking.dto.AccountDto;
import dev.hannahbanks.banking.dto.mapper.AccountMapper;
import dev.hannahbanks.banking.entity.Account;
import dev.hannahbanks.banking.repository.AccountRepository;
import dev.hannahbanks.banking.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }
}
