package com.example.webStore.services;

import com.example.webStore.models.Account;
import com.example.webStore.models.PaymentInfo;
import com.example.webStore.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository)
    {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccounts()
    {
        return accountRepository.getAllAccount();
    }

    public Account getAccountById(long id)
    {
        return accountRepository.getAccountById(id);
    }

    public void createNewAccount(Account account)
    {
        accountRepository.addNewAccount(account.getName(),
                account.getPaymentInfo().getId());
    }

    public void changeAccountPaymentInfo(PaymentInfo paymentInfo, Account account)
    {
        accountRepository.updatePaymentInfoById(paymentInfo.getId(), account.getId());
    }
}
