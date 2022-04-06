package br.com.fiap.abctechservice.service.impl;

import br.com.fiap.abctechservice.model.Assistance;
import br.com.fiap.abctechservice.repository.AssistanceRepository;
import br.com.fiap.abctechservice.service.AssistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssistanceServiceImpl implements AssistanceService {
    private AssistanceRepository repository;


    public AssistanceServiceImpl(
            @Autowired
            AssistanceRepository assistanceRepository
    ) {
        this.repository = assistanceRepository;
    }
    @Override
    public List<Assistance> getAssistsList() {
        return this.repository.findAll();
    }
}
