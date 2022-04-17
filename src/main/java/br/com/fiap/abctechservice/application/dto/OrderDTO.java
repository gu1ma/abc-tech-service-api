package br.com.fiap.abctechservice.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderDTO {
    private Long operatorId;
    private List<Long> services;
    private OrderLocationDTO startOrderLocation;
    private OrderLocationDTO endOrderLocation;
}
