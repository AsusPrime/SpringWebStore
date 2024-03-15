package com.example.webStore.controllers;

import com.example.webStore.services.BasketService;
import com.example.webStore.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllBookAtBasket {
    private final BasketService basketService;
    private final BookService bookService;

    public ControllBookAtBasket(BasketService basketService,
                                BookService bookService)
    {
        this.basketService = basketService;
        this.bookService = bookService;
    }

    @PostMapping("/buyBook")
    public ResponseEntity<String> buyBook(@RequestBody BookBody book)
    {
        basketService.addBookToTheBasket(bookService.getBookById(book.getBookId()));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/deleteBook")
    public ResponseEntity<String> deleteBook(@RequestBody BookBody book)
    {
        basketService.removeBookFromBasket(bookService.getBookById(book.getBookId()));//?
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

class BookBody
{
    private int bookId;

    public int getBookId()
    {
        return bookId;
    }
}
