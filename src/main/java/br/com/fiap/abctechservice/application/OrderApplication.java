package br.com.fiap.abctechservice.application;

import br.com.fiap.abctechservice.application.dto.OrderDTO;

public interface OrderApplication {
    void createOrder(OrderDTO orderDTO);
}
