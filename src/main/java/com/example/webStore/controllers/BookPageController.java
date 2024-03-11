package com.example.webStore.controllers;

import com.example.webStore.models.Book;
import com.example.webStore.models.Review;
import com.example.webStore.services.BookService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Controller
public class BookPageController {

    private final BookService bookService;

    public BookPageController(BookService bookService)
    {
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public String bookPage(Model model,
        @RequestParam(name = "id", required = true) int id)
    {
        Book book = bookService.getBookById(id);
        List<Review> comments = bookService.getCommentsByBookId(id);
        model.addAttribute("book", book);
        model.addAttribute("comments", comments);
        return "book";
    }

    @GetMapping("/book/book.jpg")
    public ResponseEntity<byte[]> getBookImage() throws IOException {
        Resource resource = new ClassPathResource("templates/book.jpg");
        byte[] imageBytes = Files.readAllBytes(resource.getFile().toPath());
        MediaType mediaType = MediaType.IMAGE_JPEG;
        return ResponseEntity.ok().contentType(mediaType).body(imageBytes);
    }

    @GetMapping("/book/account.png")
    public ResponseEntity<byte[]> getAccountImage() throws IOException {
        Resource resource = new ClassPathResource("templates/account.png");
        byte[] imageBytes = Files.readAllBytes(resource.getFile().toPath());
        MediaType mediaType = MediaType.IMAGE_JPEG;
        return ResponseEntity.ok().contentType(mediaType).body(imageBytes);
    }
}
