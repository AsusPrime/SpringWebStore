package com.example.webStore.models;

import java.util.List;

public class Basket {
    private List<Book> books;
    private Price fullPrice = new Price();

    public List<Book> getBooks()
    {
        return books;
    }
    public void addBook(Book book)
    {
        this.books.add(book);
    }
    public void removeBook(Book book)
    {
        this.books.remove(book);
    }
    public void removeBook(int index)
    {
        this.books.remove(index);
    }
    public double getFullPrice()
    {
        calcFullPrice();
        return fullPrice.getPrice();
    }
    private void calcFullPrice()
    {
        double sum = 0;
        for(var book : books)
        {
            sum += book.getFinalPrice();
        }
        fullPrice.setPrice(sum);
    }
}
