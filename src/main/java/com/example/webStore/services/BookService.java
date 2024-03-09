package com.example.webStore.services;

import com.example.webStore.models.Book;
import com.example.webStore.models.Image;
import com.example.webStore.models.Review;
import com.example.webStore.repositories.BookRepository;
import com.example.webStore.repositories.CommentRepository;
import com.example.webStore.repositories.ImageRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final CommentRepository commentRepository;
    private final ImageRepository imageRepository;

    public BookService(BookRepository bookRepository,
                       CommentRepository commentRepository,
                       ImageRepository imageRepository)
    {
        this.bookRepository = bookRepository;
        this.commentRepository = commentRepository;
        this.imageRepository = imageRepository;
    }

    public List<Book> getAllBooks()
    {
        return bookRepository.getAllBooks();
    }

    public List<Book> getAllBooksSortedByPromotion()
    {
        return bookRepository.getAllBooksSortedByPromotion();
    }

    public Book getBookById(long id)
    {
        return bookRepository.getBookById(id);
    }

    public List<Book> getAllBooksLikeName(String name)
    {
        return bookRepository.findByNameContaining(name);
    }

    public void addNewBook(Book book)
    {
        bookRepository.addNewBook(book.getName(), book.getAuthor(),
                book.getPrice(), book.getCount(), book.getPromotionPercent());
    }

    public List<Image> getImageForBookByBookId(long bookId)
    {
        return imageRepository.getImageByBookId(bookId);
    }

    public List<Review> getCommentsByBookId(long bookId)
    {
        return commentRepository.getAllCommentsByBookId(bookId);
    }

    public void reduceCountBooksByBookId(long bookId)
    {
        bookRepository.updateCountById(bookRepository.getBookById(bookId)
                .getCount() - 1, bookId);
    }

    public void reduceCountListOfBooks(List<Book> books)
    {
        for(var b : books)
        {
            increaseCountBooksByBookId(b.getId());
        }
    }

    public void increaseCountBooksByBookId(long bookId)
    {
        bookRepository.updateCountById(bookRepository.getBookById(bookId)
                .getCount() + 1, bookId);
    }

/*    public List<Book> getAllBooksSortedByCommentsCount()
    {
        List<Book> books;
        List<Review> comments = commentRepository.getAllComments();
        HashMap<Long, Integer> booksByComments = new HashMap<>();

        for(Review comment : comments)
        {
            booksByComments.put(comment.getBookId(),
                    booksByComments.getOrDefault(comment.getBookId(), 0) + 1);
        }

        booksByComments.entrySet().stream()
                .sorted(Map.Entry.<Long, Integer>comparingByValue().reversed())
                .forEach(entry->books.add());
    }*/
}
