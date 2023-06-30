package com.dewiz.restwithspringsecurity.service;

import com.dewiz.restwithspringsecurity.model.Account;

import java.util.List;

public interface AccountService {
    Account createAccount(Account account);
    Account findByUsername(String username);
    List<Account> getAccounts();
}
