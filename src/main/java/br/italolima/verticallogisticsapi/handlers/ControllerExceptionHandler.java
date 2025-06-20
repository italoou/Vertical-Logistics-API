package br.italolima.verticallogisticsapi.handlers;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.italolima.verticallogisticsapi.dtos.ApiResponseDTO;
import br.italolima.verticallogisticsapi.dtos.ErrorDTO;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponseDTO<ErrorDTO>> notFound(IllegalArgumentException exception,
            HttpServletRequest request) {

    	ErrorDTO error = new ErrorDTO(
                ZonedDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Fail on file processing ",
                exception.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponseDTO<ErrorDTO>(
                false,
                "Error: Fail on file Processing",
                null,
                error));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseDTO<ErrorDTO>> internalErrorException(Exception e, HttpServletRequest request) {

    	ErrorDTO error = new ErrorDTO(
                ZonedDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "An unexpected problem occurred.",
                e.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponseDTO<ErrorDTO>(
                false,
                "Error: " + e.getMessage(),
                null,
                error));
    }
}
