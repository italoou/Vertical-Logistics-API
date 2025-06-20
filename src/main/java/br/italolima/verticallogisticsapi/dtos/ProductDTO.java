package br.italolima.verticallogisticsapi.dtos;

import br.italolima.verticallogisticsapi.models.ProductPurchased;

public record ProductDTO(
		Long product_id,
		String value
		) {
	public static ProductDTO toDto(ProductPurchased entity) {
		
		return new ProductDTO(entity.getProduct().getId(), entity.getAmount().toString());

    }
}