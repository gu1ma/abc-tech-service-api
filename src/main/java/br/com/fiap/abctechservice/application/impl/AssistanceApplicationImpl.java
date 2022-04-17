package br.com.fiap.abctechservice.application.impl;

import br.com.fiap.abctechservice.application.AssistanceApplication;
import br.com.fiap.abctechservice.application.dto.AssistDTO;
import br.com.fiap.abctechservice.model.Assistance;
import br.com.fiap.abctechservice.service.AssistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AssistanceApplicationImpl implements AssistanceApplication {

    private final AssistanceService assistanceService;

    public AssistanceApplicationImpl(
            @Autowired
            AssistanceService assistanceService
    ) {
        this.assistanceService = assistanceService;
    }

    @Override
    public List<AssistDTO> getAssists() {
        List<Assistance> assistancesList = this.assistanceService.getAssistsList();
        return assistancesList.stream().map( assistance -> new
                AssistDTO(assistance.getId(),
                assistance.getName(),
                assistance.getDescription())
        ).collect(Collectors.toList());
    }
}
