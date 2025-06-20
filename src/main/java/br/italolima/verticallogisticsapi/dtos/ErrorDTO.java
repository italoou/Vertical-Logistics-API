package br.italolima.verticallogisticsapi.dtos;

import java.time.ZonedDateTime;

public record ErrorDTO(ZonedDateTime timestamp, Integer status, String error, String message, String path) {
}
