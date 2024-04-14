package com.example.webStore.controllers;

import com.example.webStore.models.Book;
import com.example.webStore.services.BookService;
import com.example.webStore.services.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.nio.file.Files;

@RequiredArgsConstructor
@Controller
public class AddBookController {

    private final BookService bookService;
    private final LoginService loginService;

    @GetMapping("/add_book")
    public String getPage(){
        return "add_book.html";
    }

    @PostMapping("/add_book")
    public String addBook(@RequestParam(name = "name") String name,
                          @RequestParam(name = "price") double price,
                          @RequestParam(name = "count") int count)
    {
        Book book = new Book();
        book.setName(name);
        book.setPrice(price);
        book.setCount(count);
        book.setAuthor(loginService.getAccount().getName());
        book.setPromotion(0);

        bookService.addNewBook(book);

        return getPage();
    }

    @GetMapping("/add_book/book.jpg")
    public ResponseEntity<byte[]> getBookImage() throws IOException {
        Resource resource = new ClassPathResource("templates/book.jpg");
        byte[] imageBytes = Files.readAllBytes(resource.getFile().toPath());
        MediaType mediaType = MediaType.IMAGE_JPEG;
        return ResponseEntity.ok().contentType(mediaType).body(imageBytes);
    }

    @GetMapping("/add_book/basket.jpg")
    public ResponseEntity<byte[]> getBasketImage() throws IOException {
        Resource resource = new ClassPathResource("templates/basket.jpg");
        byte[] imageBytes = Files.readAllBytes(resource.getFile().toPath());
        MediaType mediaType = MediaType.IMAGE_JPEG;
        return ResponseEntity.ok().contentType(mediaType).body(imageBytes);
    }

    @GetMapping("/add_book/account.png")
    public ResponseEntity<byte[]> getAccountImage() throws IOException {
        Resource resource = new ClassPathResource("templates/account.png");
        byte[] imageBytes = Files.readAllBytes(resource.getFile().toPath());
        MediaType mediaType = MediaType.IMAGE_JPEG;
        return ResponseEntity.ok().contentType(mediaType).body(imageBytes);
    }
}
