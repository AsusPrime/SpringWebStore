package com.example.webStore.services;

import com.example.webStore.models.Account;
import com.example.webStore.models.Book;
import com.example.webStore.models.Order;
import com.example.webStore.models.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.sql.Date;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final OrderService orderService;
    private final BookService bookService;
    private final BasketService basketService;

    @Transactional
    public void makeTransaction(Account account, PaymentInfo paymentInfo)
    {
        //тут маэ бути бызнес логыка

        orderService.createNewOrder(account, paymentInfo.getAddress(), basketService);

        bookService.reduceCountListOfBooks(basketService.getBooksInBasket());

        basketService.clearBasket();
    }
    //mothod without account(make account with id 0)
    @Transactional
    public void makeTransaction(PaymentInfo paymentInfo)
    {
        //тут маэ бути бызнес логыка

        Account a = new Account();
        a.setId(0);
        orderService.createNewOrder(a, paymentInfo.getAddress(), basketService);

        bookService.reduceCountListOfBooks(basketService.getBooksInBasket());

        basketService.clearBasket();
    }
}
