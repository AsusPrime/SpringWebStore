package com.example.webStore.repositories;

import com.example.webStore.models.Review;
import com.example.webStore.services.AccountService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentsRepository {
    private final JdbcTemplate jdbc;
    private final AccountService accountService;

    public CommentsRepository(JdbcTemplate jdbc, AccountService accountService)
    {
        this.jdbc = jdbc;
        this.accountService = accountService;
    }

    public Review getCommentById(long id)
    {
        String sql = "SELECT * FROM comment WHERE id = ?";

        RowMapper<Review> reviewRowMapper = (r, i) -> {
            Review comment = new Review();
            comment.setId(r.getInt("id"));
            comment.setSender(accountService.getAccountById(r.getInt("accountId")));
            comment.setComment(r.getString("text"));
            comment.setAssessment(r.getInt("assessment"));
            comment.setBookId(r.getInt("bookId"));
            return comment;
        };

        return jdbc.queryForObject(sql, reviewRowMapper, id);
    }

    public List<Review> getAllCommentsByBookId(long id)
    {
        String sql = "SELECT * FROM comment WHERE bookId = ?";

        RowMapper<Review> reviewRowMapper = (r, i) -> {
            Review comment = new Review();
            comment.setId(r.getInt("id"));
            comment.setSender(accountService.getAccountById(r.getInt("accountId")));
            comment.setComment(r.getString("text"));
            comment.setAssessment(r.getInt("assessment"));
            comment.setBookId(r.getInt("bookId"));
            return comment;
        };

        return jdbc.query(sql, reviewRowMapper, id);
    }

    public void addNewComment(int bookId, String comment, int assessment,
                              int senderId)
    {
        String sql = "INSERT INTO comment (accountId, assessment, text, bookId) " +
                "VALUES(?, ?, ?, ?)";

        jdbc.update(sql, senderId, assessment, comment, bookId);
    }
}
