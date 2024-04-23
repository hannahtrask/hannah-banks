package dev.hannahbanks.banking.repository;

import dev.hannahbanks.banking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
