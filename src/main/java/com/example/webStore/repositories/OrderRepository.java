package com.example.webStore.repositories;

import com.example.webStore.models.Order;
import org.springframework.data.jdbc.repository.query.*;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    @Query("SELECT * FROM order")
    public List<Order> getAllOrders();

    @Query("SELECT * FROM order WHERE accountId = :accountId")
    public List<Order> getAllOrdersByAccountId(long accountId);

    @Query("SELECT * FROM order WHERE id = :id")
    public Order getOrderById(long id);

    @Query("INSERT INTO order (accountId, address) VALUES(:accountId, :address)")
    @Modifying
    public void addNewOrder(long accountId, String address);

    @Query("UPDATE order SET address = :address")
    @Modifying
    public void changeOrderAddress(String address);
}
