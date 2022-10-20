package com.papaco.papacoapigateway.account.application;

import com.papaco.papacoapigateway.account.application.dto.AccountResponse;
import com.papaco.papacoapigateway.account.domain.Account;
import com.papaco.papacoapigateway.account.domain.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountResponse findAccount(String userName) {
        Account account = accountRepository
                .findByUserName(userName)
                .orElseThrow(IllegalArgumentException::new);
        return AccountResponse.of(account);
    }
}
