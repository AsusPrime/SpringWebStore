package com.example.webStore.controllers;

import com.example.webStore.services.BasketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/basket")
public class BasketController {

    private final BasketService basketService;

    public BasketController(BasketService basketService)
    {
        this.basketService = basketService;
    }

    @GetMapping
    public String basketPage(Model model)
    {
        model.addAttribute("books", basketService.getBooksInBasket());
        model.addAttribute("price", basketService.getFullPrice());
        return "basket";
    }
}
