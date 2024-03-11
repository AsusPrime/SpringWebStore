package com.example.webStore.repositories;

import com.example.webStore.models.Assessment;
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
            Assessment a = new Assessment();
            a.addRating(r.getInt("assessment"));
            comment.setAssessment(a);
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
            Assessment a = new Assessment();
            a.addRating(r.getInt("assessment"));
            comment.setAssessment(a);
            comment.setBookId(r.getInt("bookId"));
            return comment;
        };

        return jdbc.query(sql, reviewRowMapper, id);
    }
}