package ru.itis.javalab.repositories;

import ru.itis.javalab.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrdersRepository extends CrudRepository<Order> {

    Optional<Order> findActiveOrderByUserId(long id);

    void save(long user_id, long car_id);

    Optional<Order> findOrderById(long id);

    void setOrderPrice(int price, long id);

    void setOrderAddress(String address, long id);

    void setTimeOfOrderTaking(String time, long id);

    void setOrderDate(String date, long id);

    void setOrderNonActive(long id);

    List<Order> finaAllNonActiveByUserId(long id);

}
