package com.example.webStore.repositories;

import com.example.webStore.models.Review;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.web.config.ReactiveQuerydslWebConfiguration;

import java.util.List;

public interface CommentRepository extends CrudRepository<Review, Long> {

    @Query("SELECT * FROM comment")
    public List<Review> getAllComments();

    @Query("SELECT * FROM comment WHERE id = :id")
    public Review getCommentById(long id);

    @Query("SELECT * FROM comment WHERE bookId = :id")
    public List<Review> getAllCommentsByBookId(long id);

    @Query("SELECT * FROM comment WHERE accountId = :id")
    public List<Review> getAllCommentsByAccountId(long id);

    //add
    @Query("INSERT INTO comment (accountId, assessment, text, bookId) " +
            "VALUES (:accountId, :assessment, :text, :bookId)")
    @Modifying
    public void addNewBook(long accountId, int assessment, String text, long bookId);

    //change assessment
    @Query("UPDATE comment SET assessment = :assessment WHERE id = :id")
    @Modifying
    public void updateAssessmentById(long id);

    //change text
    @Query("UPDATE comment SET text = :text WHERE id = :id")
    @Modifying
    public void updateTextById(String text, long id);
}
