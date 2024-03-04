package com.example.webStore.services;

import com.example.webStore.models.Account;
import com.example.webStore.models.Book;
import com.example.webStore.models.PaymentInfo;
import com.example.webStore.repositories.OrderItemRepository;
import com.example.webStore.repositories.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderService(OrderRepository orderRepository,
                        OrderItemRepository orderItemRepository,
                        BookService bookService)
    {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public void createNewOrder(Account account, String address,
                               BasketService basketService)
    {
        long id = orderRepository.getAllOrders().size()+1;
        orderRepository.addNewOrder(account.getId(), address);
        for(Book b : basketService.getBooksInBasket())
        {
            orderItemRepository.addNewOrderItem(id, b.getId());
        }
    }
}
