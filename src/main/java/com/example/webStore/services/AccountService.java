package com.example.webStore.services;

import com.example.webStore.models.Account;
import com.example.webStore.models.AccountLoginData;
import com.example.webStore.models.PaymentInfo;
import com.example.webStore.repositories.AccountLoginRepository;
import com.example.webStore.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountLoginRepository accountLoginRepository;

    public List<Account> getAllAccounts()
    {
        return accountRepository.getAllAccount();
    }

    public Account getAccountById(long id)
    {
        return accountRepository.getAccountById(id);
    }

    public void createNewAccount(String name, String email, String password)
    {
        int id = accountRepository.getAllAccount().size() + 1;
        System.out.println(id);
        accountRepository.addNewAccount(id, name);
        accountRepository.createNewAccountLoginData(id, email, password);
    }

    public void changeAccountPaymentInfo(PaymentInfo paymentInfo, Account account)
    {
        accountRepository.updatePaymentInfoById(paymentInfo.getId(), account.getId());
    }

    public Account logIn(String email, String password)
    {
        AccountLoginData logData = accountLoginRepository.getAccountLoginDataByEmail(email);
        if(logData == null) {return null;}
        if(!logData.getPassword().equals(password)) {return null;}
        return accountRepository.getAccountById(logData.getAccountId());
    }
}
