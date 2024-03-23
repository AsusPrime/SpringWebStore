package com.example.webStore.controllers;

import com.example.webStore.models.Account;
import com.example.webStore.models.AccountLoginData;
import com.example.webStore.services.AccountService;
import com.example.webStore.services.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService login;

    @GetMapping
    public String getLoginPage()
    {
        return "login.html";
    }

    @PostMapping
    public String logIn(@RequestParam String email,
                        @RequestParam String password)
    {
        login.logIn(email, password);
        if(login.getAccount() == null){return "login.html";}
        return "redirect:/";
    }
}
