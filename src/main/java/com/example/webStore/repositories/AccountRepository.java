package com.example.webStore.repositories;

import com.example.webStore.models.Account;
import com.example.webStore.models.AccountLoginData;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {

    @Query("SELECT * FROM account")
    public List<Account> getAllAccount();

    @Query("SELECT * FROM account WHERE id = :id")
    public Account getAccountById(long id);

    @Query("INSERT INTO account (name) " +
            "VALUES(:name)")
    @Modifying
    public void addNewAccount(String name);

    @Query("INSERT INTO account (id, name) " +
            "VALUES(:id, :name)")
    @Modifying
    public void addNewAccount(int id, String name);

    @Query("INSERT INTO account_login_data (accountId, email, password) " +
            "VALUES(:accountId, :email, :password)")
    @Modifying
    public void createNewAccountLoginData(int accountId,
                                          String email, String password);

    //change name
    @Query("UPDATE account SET name = :name WHERE id = :id")
    @Modifying
    public void updateNameById(String name, long id);

    //add paymentInfo
    @Query("UPDATE account SET paymentInfo = :paymentInfoId WHERE id = :id")
    @Modifying
    public void updatePaymentInfoById(long paymentInfoId, long id);
}
