package com.example.webStore.repositories;

import com.example.webStore.models.Book;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    @Query("SELECT * FROM book")
    public List<Book> getAllBooks();

    @Query("SELECT * FROM book WHERE id = :id")
    public Book getBookById(long id);

    //add book
    @Query("INSERT INTO book (name, author, price, count, promotion) " +
            "VALUES(:name, :author, :price, :count, :promotion)")
    @Modifying
    public void addNewBook(String name, String author, double price, int count, int promotion);

    //change price
    @Query("UPDATE book SET price = :price WHERE id = :id")
    @Modifying
    public void updatePriceById(double price, long id);

    //change count
    @Query("UPDATE book SET count = :count WHERE id = :id")
    @Modifying
    public void updateCountById(int count, long id);

    //change promotion
    @Query("UPDATE book SET promotion = :promotion WHERE id = :id")
    @Modifying
    public void updatePromotionById(int promotion, long id);
}
