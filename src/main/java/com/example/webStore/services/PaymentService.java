package com.example.webStore.services;

import com.example.webStore.models.Account;
import com.example.webStore.models.Book;
import com.example.webStore.models.Order;
import com.example.webStore.models.PaymentInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.sql.Date;

@Service
public class PaymentService {

    private final OrderService orderService;
    private final BookService bookService;

    public PaymentService(OrderService orderService,
                          BookService bookService)
    {
        this.orderService = orderService;
        this.bookService = bookService;
    }

    @Transactional
    public void makeTransaction(Account account, String address,
                                BasketService basketService, PaymentInfo paymentInfo)
    {
        //тут мають выдбуватися транзацкыы грошей выд користувача до нас

        orderService.createNewOrder(account, address, basketService);

        bookService.reduceCountListOfBooks(basketService.getBooksInBasket());

        basketService.clearBasket();
    }
}
