package ru.itis.javalab.services;

import ru.itis.javalab.models.Order;
import ru.itis.javalab.repositories.OrdersRepository;

import java.util.List;
import java.util.Optional;

public class OrdersServiceImpl implements OrderService {

    OrdersRepository ordersRepository;

    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }


    @Override
    public void saveOrder(long user_id, long car_id) {
        ordersRepository.save(user_id, car_id);
    }

    @Override
    public Optional<Order> getActiveOrderByUserId(long id) {
        return ordersRepository.findActiveOrderByUserId(id);
    }

    @Override
    public Optional<Order> getOrderById(long id) {
        return ordersRepository.findOrderById(id);
    }

    @Override
    public void deleteOrder(Order entity) {
        ordersRepository.delete(entity);
    }

    @Override
    public void setOrderPrice(int price, long id) {
        ordersRepository.setOrderPrice(price, id);
    }

    @Override
    public void setOrderAddress(String address, long id) {
        ordersRepository.setOrderAddress(address, id);
    }

    @Override
    public void setTimeOfOrderTaking(String time, long id) {
        ordersRepository.setTimeOfOrderTaking(time, id);
    }

    @Override
    public void setOrderNonActive(long id) {
        ordersRepository.setOrderNonActive(id);
    }

    @Override
    public void setOrderDate(String date, long id) {
        ordersRepository.setOrderDate(date, id);
    }

    @Override
    public List<Order> getAllNonActiveByUserId(long id) {
        return ordersRepository.finaAllNonActiveByUserId(id);
    }
}
