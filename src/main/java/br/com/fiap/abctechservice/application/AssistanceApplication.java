package br.com.fiap.abctechservice.application;

import br.com.fiap.abctechservice.application.dto.AssistDTO;

import java.util.List;

public interface AssistanceApplication {
    public List<AssistDTO> getAssists();
}
