package com.example.webStore.controllers;

import com.example.webStore.models.Book;
import com.example.webStore.services.BookService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.MediaType;
import java.io.IOException;

import java.nio.file.Files;
import java.util.List;

@Controller
public class MainPageController {

    private final BookService bookService;

    public MainPageController(BookService bookService)
    {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String homePage(Model model,
        @RequestParam(name = "search", required = false) String search)
    {
        List<Book> books;
        if(search != null)
        {
            books = bookService.getAllBooksLikeName(search);
        } else {
            books = bookService.getAllBooks();
        }
        model.addAttribute("books", books);
        return "home";
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
