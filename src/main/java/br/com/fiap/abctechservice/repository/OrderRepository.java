package br.com.fiap.abctechservice.repository;

import br.com.fiap.abctechservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
