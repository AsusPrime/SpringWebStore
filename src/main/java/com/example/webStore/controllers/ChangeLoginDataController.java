package com.example.webStore.controllers;

import com.example.webStore.repositories.AccountLoginRepository;
import com.example.webStore.services.AccountService;
import com.example.webStore.services.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ChangeLoginDataController {

    private final AccountService accountService;
    private final LoginService loginService;

    @PostMapping("/change_data")
    public String changeLoginData(
            @RequestParam(required = false, name = "login") String login,
            @RequestParam(required = false, name = "password") String password)
    {
        accountService.ChangeLoginData(login, password, (int)loginService.getAccount().getId());
        return"redirect:/admin_panel";
    }
}
