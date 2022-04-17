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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class OrderServiceTest {
    @Mock
    private OrderRepository orderRepository;
    private OrderService orderService;
    @Mock
    private AssistanceRepository assistanceRepository;

    @BeforeEach
    public void init () {
        MockitoAnnotations.openMocks(this);
        orderService = new OrderServiceImpl(orderRepository, assistanceRepository);
        when(assistanceRepository.findById(any())).thenReturn(Optional.of(new Assistance(1L, "Mock test", "MOck Description")));
    }

    @Test
    public void checkIfOrderIsSaving() {
        Order order = new Order();
        order.setId(123L);

        order.setOperatorId(321L);

        orderService.saveOrder(order, getAssistancesList(1));

        verify(orderRepository, Mockito.times(1)).save(order);
    }

    @Test
    public void shouldNotSaveIfHaveNotAssistances() {
        Order order = new Order();
        order.setId(123L);
        order.setOperatorId(321L);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> orderService.saveOrder(order, List.of()));
    }

    @Test()
    public void shouldNotSaveIfExceedsMaxAssists() {
        Order order = new Order();
        order.setId(123L);
        order.setOperatorId(321L);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> orderService.saveOrder(order, getAssistancesList(22)));
    }

    public List<Long> getAssistancesList(int qtd) {
        List<Long> arrayIds = new ArrayList<>();

        for(int a = 0; a < qtd; a++) {
            arrayIds.add(Integer.toUnsignedLong(a));
        }

        return arrayIds;
    }
}
