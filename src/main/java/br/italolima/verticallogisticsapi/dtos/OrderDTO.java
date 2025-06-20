package br.italolima.verticallogisticsapi.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.italolima.verticallogisticsapi.models.Order;

public record OrderDTO(
		Long order_id,
		String total,
		String date,
		List<ProductDTO> products
		) {
	
	public static OrderDTO toDto(Order entity) {
		
		List<ProductDTO> products = new ArrayList<ProductDTO>();
		
		if (Objects.nonNull(entity.getProductPurchased())) {
			products = entity.getProductPurchased().stream().map(ProductDTO::toDto).toList();
		}
			
		return new OrderDTO(entity.getId(), entity.getTotal().toString(), entity.getDate().toString(), products);
    }

}