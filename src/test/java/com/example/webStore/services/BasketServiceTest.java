package com.example.webStore.services;

import com.example.webStore.models.Book;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasketServiceTest {

    @Test
    public void testAddBookInBasket()
    {
        BasketService basketService = new BasketService();

        Book book1 = new Book();
        book1.setCount(12);
        book1.setName("ababab");
        book1.setAuthor("ferfeefef");
        book1.setPrice(12.55);
        book1.setPromotion(0);

        basketService.addBookToTheBasket(book1);

        List<Book> books = new ArrayList<Book>();
        books.add(book1);

        assertEquals(books, basketService.getBooksInBasket());
    }

    @Test
    public void testRemoveBookFromBasket()
    {
        BasketService basketService = new BasketService();

        Book book1 = new Book();
        Book book2 = new Book();
        book1.setCount(12);
        book2.setCount(12);
        book1.setName("ababab");
        book2.setName("ababab");
        book1.setAuthor("ferfeefef");
        book2.setAuthor("ferfeefef");
        book1.setPrice(12.55);
        book2.setPrice(12.55);
        book1.setPromotion(0);
        book2.setPromotion(0);

        basketService.addBookToTheBasket(book1);
        basketService.removeBookFromBasket(book2);

        List<Book> books = new ArrayList<Book>();

        assertEquals(books, basketService.getBooksInBasket());
    }
}
