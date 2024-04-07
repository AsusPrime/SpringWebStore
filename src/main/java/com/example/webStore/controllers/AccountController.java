package com.example.webStore.controllers;

import com.example.webStore.repositories.CommentsRepository;
import com.example.webStore.services.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.stream.events.Comment;
import java.io.IOException;
import java.nio.file.Files;

@Controller
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final LoginService loginService;
    private final CommentsRepository commentsRepository;

    @GetMapping
    public String getAccountPage(Model model)
    {
        if(loginService.getAccount() == null)
        {
            return "redirect:/login";
        }else if(loginService.getAccount().getId() == 2)
        {
            return "redirect:/admin_panel";
        }
        model.addAttribute("name",
                loginService.getAccount().getName());
        model.addAttribute("comments",
                commentsRepository.getAllCommentsByAccountId(
                        loginService.getAccount().getId()));
        return "account.html";
    }

    @GetMapping("/book.jpg")
    public ResponseEntity<byte[]> getBookImage() throws IOException {
        Resource resource = new ClassPathResource("templates/book.jpg");
        byte[] imageBytes = Files.readAllBytes(resource.getFile().toPath());
        MediaType mediaType = MediaType.IMAGE_JPEG;
        return ResponseEntity.ok().contentType(mediaType).body(imageBytes);
    }

    @GetMapping("/basket.jpg")
    public ResponseEntity<byte[]> getBasketImage() throws IOException {
        Resource resource = new ClassPathResource("templates/basket.jpg");
        byte[] imageBytes = Files.readAllBytes(resource.getFile().toPath());
        MediaType mediaType = MediaType.IMAGE_JPEG;
        return ResponseEntity.ok().contentType(mediaType).body(imageBytes);
    }

    @GetMapping("/account.png")
    public ResponseEntity<byte[]> getAccountImage() throws IOException {
        Resource resource = new ClassPathResource("templates/account.png");
        byte[] imageBytes = Files.readAllBytes(resource.getFile().toPath());
        MediaType mediaType = MediaType.IMAGE_JPEG;
        return ResponseEntity.ok().contentType(mediaType).body(imageBytes);
    }
}
