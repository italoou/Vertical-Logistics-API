package br.italolima.verticallogisticsapi.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public record LogisticDTO(
		Long userId,
	    String userName,
	    Long orderId,
	    Long productId,
	    BigDecimal amount,
	    LocalDate date
	    ) {
	
	public static LogisticDTO toDto(String line) {
		
		try {
			Long userId = Long.parseLong(line.substring(0, 10).trim());
            String userName = line.substring(10, 55).trim();
            Long orderId = Long.parseLong(line.substring(55, 65).trim());
            Long productId = Long.parseLong(line.substring(65, 75).trim());
            BigDecimal amount = new BigDecimal(line.substring(75, 87).trim());
            LocalDate date = LocalDate.parse(line.substring(87).trim(), DateTimeFormatter.ofPattern("yyyyMMdd"));
            
            return new LogisticDTO(userId, userName, orderId, productId, amount, date);

		} catch (Exception e) {
            throw new IllegalArgumentException("There has been a erro on file processing: " + line, e);
		}
			
    }
}