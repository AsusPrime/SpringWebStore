package com.example.webStore.controllers;

import com.example.webStore.services.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AdminPanelController {

    private final LoginService loginService;

    @GetMapping("/admin_panel")
    public String getPage()
    {
        if(loginService.getAccount() == null)
        {
            return "redirect:/login";
        }
        else if(loginService.getAccount().getId() != 2)
        {
            return "redirect:/account";
        }
        return "admin_panel.html";
    }

    @PostMapping("/admin_panel")
    public String changeLoginData(
            @RequestParam(required = false, name = "login") String login,
            @RequestParam(required = false, name = "password") String password)
    {
        return "admin_panel.html";
    }
}
