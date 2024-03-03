package com.example.webStore.repositories;

import com.example.webStore.models.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {

    @Query("SELECT * FROM account")
    public List<Account> getAllAccount();

    @Query("SELECT * FROM account WHERE id = :id")
    public Account getAccountById(long id);

    @Query("INSERT INTO account (name, paymentInfoId) " +
            "VALUES(:name, :paymentInfoId)")
    @Modifying
    public void addNewAccount(String name, long paymentInfoId);

    //change name
    @Query("UPDATE account SET name = :name WHERE id = :id")
    @Modifying
    public void updateNameById(String name, long id);

    //add paymentInfo
    @Query("UPDATE account SET paymentInfo = :paymentInfoId WHERE id = :id")
    @Modifying
    public void updatePaymentInfoById(long paymentInfoId, long id);
}
