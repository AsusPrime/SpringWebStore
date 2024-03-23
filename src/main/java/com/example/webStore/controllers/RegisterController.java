package com.example.webStore.controllers;

import com.example.webStore.models.Account;
import com.example.webStore.services.AccountService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {

    private final AccountService accountService;

    @GetMapping
    public String getRegisterPage()
    {
        return "register.html";
    }

    @PostMapping
    public String createNewAccount(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password)
    {
        accountService.createNewAccount(name,
                email, password);
        return "redirect:/login";
    }
}
