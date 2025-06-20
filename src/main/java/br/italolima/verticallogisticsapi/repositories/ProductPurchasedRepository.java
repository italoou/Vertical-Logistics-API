package br.italolima.verticallogisticsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.italolima.verticallogisticsapi.models.ProductPurchased;

public interface ProductPurchasedRepository extends JpaRepository<ProductPurchased, Long>{

	
}
