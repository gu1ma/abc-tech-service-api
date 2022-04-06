package br.com.fiap.abctechservice.service;

import br.com.fiap.abctechservice.model.Assistance;
import br.com.fiap.abctechservice.repository.AssistanceRepository;
import br.com.fiap.abctechservice.service.impl.AssistanceServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
public class AssistanceServiceTest {
    @Mock
    private AssistanceRepository assistanceRepository;
    private AssistanceService assistanceService;

    @BeforeEach
    public void init () {
        MockitoAnnotations.openMocks(this);
        assistanceService = new AssistanceServiceImpl(assistanceRepository);
    }

    @Test
    public void testListSuccess() {
        Assistance itemAssistance = new Assistance(1L, "mock name", "mock description");
        Assistance itemAssistance2 = new Assistance(2L, "other mock name", "other mock description");

        when(assistanceRepository.findAll()).thenReturn(List.of(itemAssistance, itemAssistance2));

        List<Assistance> values = assistanceService.getAssistsList();

        Assertions.assertEquals(values.size(), 2);
        Assertions.assertSame(values.get(0), itemAssistance);
        Assertions.assertSame(values.get(1), itemAssistance2);
    }

    @Test
    public void testListEmpty() {
        when(assistanceRepository.findAll()).thenReturn(List.of());

        List<Assistance> values = assistanceService.getAssistsList();

        Assertions.assertEquals(values.size(), 0);
    }
}
