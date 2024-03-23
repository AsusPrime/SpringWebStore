package com.example.webStore.services;

import com.example.webStore.models.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.net.PasswordAuthentication;

@Service
@SessionScope
@RequiredArgsConstructor
public class LoginService {
    private Account account = null;
    private final AccountService accountService;

    public void logIn(String email, String password)
    {
        account = accountService.logIn(email, password);
    }

    public Account getAccount()
    {
        return account;
    }
}
