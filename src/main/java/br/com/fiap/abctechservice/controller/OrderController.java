package br.com.fiap.abctechservice.controller;

import br.com.fiap.abctechservice.model.Order;
import br.com.fiap.abctechservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService service;

    public OrderController(
            @Autowired
            OrderService orderService
    ) {
        this.service = orderService;
    }

    @GetMapping("/teste") public ResponseEntity<String> teste() {
        return ResponseEntity.ok("teste pai");
    }

    @GetMapping("")
    public ResponseEntity<List<Order>> getOrders() {
        List<Order> orders = this.service.getOrderList();
        return ResponseEntity.ok(orders);
    }
}
