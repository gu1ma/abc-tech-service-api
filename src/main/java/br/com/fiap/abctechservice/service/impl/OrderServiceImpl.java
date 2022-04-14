package br.com.fiap.abctechservice.service.impl;

import br.com.fiap.abctechservice.model.Order;
import br.com.fiap.abctechservice.repository.OrderRepository;
import br.com.fiap.abctechservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository repository;

    public OrderServiceImpl(
            @Autowired
            OrderRepository orderRepository
    ) {
        this.repository = orderRepository;
    }

    @Override
    public List<Order> getOrderList() {
        return this.repository.findAll();
    }

    @Override
    public void saveOrder(Order order) {
        if(!order.hasMinAssists()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if(order.exceedsMaxAssists()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        repository.save(order);
    }
}
