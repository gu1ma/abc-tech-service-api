package br.com.fiap.abctechservice.application.impl;

import br.com.fiap.abctechservice.application.OrderApplication;
import br.com.fiap.abctechservice.application.dto.OrderDTO;
import br.com.fiap.abctechservice.application.dto.OrderLocationDTO;
import br.com.fiap.abctechservice.model.Order;
import br.com.fiap.abctechservice.model.OrderLocation;
import br.com.fiap.abctechservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderApplicationImpl implements OrderApplication {
    private final OrderService orderService;

    public OrderApplicationImpl(
            @Autowired
            OrderService orderService
    ) {
        this.orderService = orderService;
    }

    @Override
    public void createOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setOperatorId(orderDTO.getOperatorId());
        order.setStartOrderLocation(getOrderLocationFromOrderLocationDTO(orderDTO.getStart()));
        order.setEndOrderLocation(getOrderLocationFromOrderLocationDTO(orderDTO.getEnd()));

        this.orderService.saveOrder(order, orderDTO.getServices());
    }

    private OrderLocation getOrderLocationFromOrderLocationDTO(OrderLocationDTO orderLocationDTO) {
        OrderLocation location = new OrderLocation();
        location.setDate(orderLocationDTO.getDateTime());
        location.setLatitude(orderLocationDTO.getLatitude());
        location.setLongitude(orderLocationDTO.getLongitude());

        return location;
    }
}
