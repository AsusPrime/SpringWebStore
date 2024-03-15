package com.example.webStore.services;

import com.example.webStore.models.Book;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Service
@SessionScope
public class BasketService {

    private List<Book> booksInBasket = new ArrayList<Book>();

    public void addBookToTheBasket(Book book)
    {
        booksInBasket.add(book);
    }

    public List<Book> getBooksInBasket()
    {
        return booksInBasket;
    }

    public void removeBookFromBasket(Book book)
    {
        booksInBasket.remove(book);
    }

    public void clearBasket()
    {
        booksInBasket.clear();
    }

    public double getFullPrice()
    {
        double sum = 0;
        for(var b : booksInBasket)
        {
            sum += b.getPrice();
        }

        return sum;
    }
}
