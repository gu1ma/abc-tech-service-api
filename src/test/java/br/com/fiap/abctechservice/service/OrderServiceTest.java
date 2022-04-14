package br.com.fiap.abctechservice.service;

import br.com.fiap.abctechservice.model.Assistance;
import br.com.fiap.abctechservice.model.Order;
import br.com.fiap.abctechservice.repository.AssistanceRepository;
import br.com.fiap.abctechservice.repository.OrderRepository;
import br.com.fiap.abctechservice.service.impl.AssistanceServiceImpl;
import br.com.fiap.abctechservice.service.impl.OrderServiceImpl;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class OrderServiceTest {
    @Mock
    private OrderRepository orderRepository;
    private OrderService orderService;

    @BeforeEach
    public void init () {
        MockitoAnnotations.openMocks(this);
        orderService = new OrderServiceImpl(orderRepository);
    }

    @Test
    public void checkIfOrderIsSaving() {
        Order order = new Order();
        List<Assistance> assistances = getAssistancesList(1);
        order.setId(123L);
        order.setServices(assistances);
        order.setOperatorId(321L);

        orderService.saveOrder(order);

        //Mockito.verify(orderRepository, Mockito.times(1))
        verify(orderRepository, Mockito.times(1)).save(order);
    }

    @Test
    public void shouldNotSaveIfHaveNotAssistances() {
        Order order = new Order();
        List<Assistance> assistances = getAssistancesList(0);
        order.setId(123L);
        order.setOperatorId(321L);
        order.setServices(assistances);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> orderService.saveOrder(order));
    }

    @Test()
    public void shouldNotSaveIfExceedsMaxAssists() {
        Order order = new Order();
        order.setId(123L);
        order.setOperatorId(321L);
        List<Assistance> assistances;
        assistances = getAssistancesList(22);
        order.setServices(assistances);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> orderService.saveOrder(order));
    }

    public List<Assistance> getAssistancesList(int qtd) {
        List<Assistance> assistances = new ArrayList<>();

        for(int a = 0; a < qtd; a++) {
            assistances.add(new Assistance(Long.valueOf(a), "mockTitle: " + a, "mockDesc: " + a));
        }

        return assistances;
    }
}
