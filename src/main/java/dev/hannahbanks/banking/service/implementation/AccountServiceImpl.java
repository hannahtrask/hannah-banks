package dev.hannahbanks.banking.service.implementation;

import dev.hannahbanks.banking.dto.AccountDto;
import dev.hannahbanks.banking.dto.mapper.AccountMapper;
import dev.hannahbanks.banking.entity.Account;
import dev.hannahbanks.banking.repository.AccountRepository;
import dev.hannahbanks.banking.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

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

//    @Override
//    public AccountDto getAllAccounts() {
//        List<Account> accounts = accountRepository.findAll();
//        return (AccountDto) accounts;
//    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found " + id));
        return AccountMapper.mapToAccountDto(account);
    }
}
