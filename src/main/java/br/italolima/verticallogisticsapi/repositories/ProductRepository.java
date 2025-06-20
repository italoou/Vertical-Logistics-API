package br.italolima.verticallogisticsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.italolima.verticallogisticsapi.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	
}
