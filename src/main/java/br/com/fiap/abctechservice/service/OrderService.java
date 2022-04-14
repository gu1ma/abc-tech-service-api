package br.com.fiap.abctechservice.service;

import br.com.fiap.abctechservice.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrderList();
    void saveOrder(Order order);
}
