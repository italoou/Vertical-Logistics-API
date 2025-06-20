package br.italolima.verticallogisticsapi.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.italolima.verticallogisticsapi.models.User;

public record PurchaseDTO(
		Long user_id,
		String name,
		List<OrderDTO> orders) {
	
	public static PurchaseDTO toDto(User entity) {
		
		List<OrderDTO> orders = new ArrayList<OrderDTO>();
		
		if (Objects.nonNull(entity.getOrders())) {
			orders = entity.getOrders().stream().map(OrderDTO::toDto).toList();
		}
			
		return new PurchaseDTO(entity.getId(), entity.getName(), orders);
    }
}