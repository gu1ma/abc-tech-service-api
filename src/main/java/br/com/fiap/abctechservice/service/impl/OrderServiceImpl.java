package br.com.fiap.abctechservice.service.impl;

import br.com.fiap.abctechservice.model.Assistance;
import br.com.fiap.abctechservice.model.Order;
import br.com.fiap.abctechservice.repository.AssistanceRepository;
import br.com.fiap.abctechservice.repository.OrderRepository;
import br.com.fiap.abctechservice.service.AssistanceService;
import br.com.fiap.abctechservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository repository;
    private AssistanceRepository assistanceRepository;

    public OrderServiceImpl(
            @Autowired
            OrderRepository orderRepository,
            @Autowired
            AssistanceRepository assistanceRepository
    ) {
        this.repository = orderRepository;
        this.assistanceRepository = assistanceRepository;
    }

    @Override
    public List<Order> getOrderList() {
        return this.repository.findAll();
    }

    @Override
    public void saveOrder(Order order, List<Long> arrayAssists) {
        ArrayList<Assistance> assistances = new ArrayList<>();
        arrayAssists.forEach(id -> {
            Assistance assistance = this.assistanceRepository.findById(id).orElseThrow();
            assistances.add(assistance);
        });

        order.setServices(assistances);

        if(!order.hasMinAssists()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if(order.exceedsMaxAssists()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        repository.save(order);
    }
}
