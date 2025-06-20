package br.italolima.verticallogisticsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.italolima.verticallogisticsapi.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

	
}
