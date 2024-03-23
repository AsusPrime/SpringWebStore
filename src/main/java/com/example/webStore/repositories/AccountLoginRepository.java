package com.example.webStore.repositories;

import com.example.webStore.models.AccountLoginData;
import com.example.webStore.models.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AccountLoginRepository {

    private final JdbcTemplate jdbc;

    public AccountLoginData getAccountLoginDataByEmail(String email)
    {
        String sql = "SELECT * FROM account_login_data WHERE email = ?";

        RowMapper<AccountLoginData> accRowMapper = (r, i) -> {
            AccountLoginData accountLoginData = new AccountLoginData();
            accountLoginData.setId(r.getInt("id"));
            accountLoginData.setAccountId(r.getInt("accountId"));
            accountLoginData.setEmail(r.getString("email"));
            accountLoginData.setPassword(r.getString("password"));
            return accountLoginData;
        };

        return jdbc.queryForObject(sql, accRowMapper, email);
    }
}