package br.italolima.verticallogisticsapi.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.italolima.verticallogisticsapi.dtos.PurchaseDTO;
import br.italolima.verticallogisticsapi.services.LogisticService;

@RestController
@RequestMapping("/v1/logistics")
public class LogisticController {

	private LogisticService service;
	
	protected LogisticController(LogisticService logisticService) {
		this.service = logisticService;
	}
	
	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		return service.uploadFile(file);
	}
	
	@GetMapping
	public List<PurchaseDTO> getAllLogisticsInfo(
			@RequestParam(required = false) Long orderId,             
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate){
		
		return service.getAllPurchases(orderId, startDate, endDate);
	}	
}
