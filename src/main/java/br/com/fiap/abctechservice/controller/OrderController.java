package br.com.fiap.abctechservice.controller;

import br.com.fiap.abctechservice.application.OrderApplication;
import br.com.fiap.abctechservice.application.dto.OrderDTO;
import br.com.fiap.abctechservice.model.Order;
import br.com.fiap.abctechservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderApplication orderApplication;

    public OrderController(
            @Autowired
            OrderApplication orderApplication) {
        this.orderApplication = orderApplication;
    }

    @PostMapping()
    public ResponseEntity createOrder(@RequestBody OrderDTO orderDTO) {
        orderApplication.createOrder(orderDTO);
        return ResponseEntity.ok().build();
    }
}
