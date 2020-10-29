package ru.itis.javalab.services;

import ru.itis.javalab.models.Order;
import ru.itis.javalab.repositories.OrdersRepository;

public class OrdersServiceImpl implements OrderService {

    OrdersRepository ordersRepository;

    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public void saveOrder(Order enitty) {
        ordersRepository.save(enitty);
    }
}
