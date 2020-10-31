package ru.itis.javalab.services;

import ru.itis.javalab.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    void saveOrder(long user_id, long car_id);

    Optional<Order> getActiveOrderByUserId(long id);

    Optional<Order> getOrderById(long id);

    void deleteOrder(Order entity);

    void setOrderPrice(int price, long id);

    void setOrderAddress(String address, long id);

    void setTimeOfOrderTaking(String time, long id);

    void setOrderNonActive(long id);

    void setOrderDate(String date, long id);

    List<Order> getAllNonActiveByUserId(long id);

}
