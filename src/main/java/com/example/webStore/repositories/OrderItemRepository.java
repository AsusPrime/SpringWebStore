package com.example.webStore.repositories;

import com.example.webStore.models.OrderItem;
import org.springframework.data.jdbc.repository.query.*;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {

    @Query("SELECT * FROM order_item")
    public List<OrderItem> getAllOrdersItems();

    @Query("SELECT * FROM order_item WHERE orderId = :orderId")
    public List<OrderItem> getAllOrderItemsByOrderId(long orderId);

    @Query("SELECT * FROM order_item WHERE id = :id")
    public OrderItem getOrderItemById(long id);

    @Query("INSERT INTO order_item (orderId, bookId) VALUES(:orderId, :bookId)")
    @Modifying
    public void addNewOrderItem(long orderId, long bookId);

    @Query("DELETE FROM order_item WHERE id = :id")
    @Modifying
    public void deleteOrderItemById(long id);

    @Query("DELETE FROM order_item WHERE orderId = :orderId")
    @Modifying
    public void deleteAllOrderItemsByOrderId(long orderId);
}
