package br.italolima.verticallogisticsapi.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.italolima.verticallogisticsapi.dtos.LogisticDTO;
import br.italolima.verticallogisticsapi.dtos.PurchaseDTO;
import br.italolima.verticallogisticsapi.mappers.LogisticMapper;
import br.italolima.verticallogisticsapi.mappers.LogisticMapper.LogisticData;
import br.italolima.verticallogisticsapi.repositories.OrderRepository;
import br.italolima.verticallogisticsapi.repositories.ProductPurchasedRepository;
import br.italolima.verticallogisticsapi.repositories.ProductRepository;
import br.italolima.verticallogisticsapi.repositories.UserRepository;

@Service
public class LogisticService {
	
	private UserRepository userRepository;
	private OrderRepository orderRepository;
	private ProductRepository productRepository;
	private ProductPurchasedRepository productPurchasedRepository;
	
	private LogisticMapper logisticMapper;

	
	protected LogisticService(UserRepository userRepository, OrderRepository orderRepository, 
			ProductRepository productRepository, ProductPurchasedRepository productPurchasedRepository, 
			LogisticMapper logisticMapper) {
		this.userRepository = userRepository;
		this.orderRepository = orderRepository;
		this.productRepository = productRepository;
		this.productPurchasedRepository = productPurchasedRepository;
		this.logisticMapper = logisticMapper;
	}
	
	public void uploadFile(MultipartFile file) throws Exception {
		
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))){
            
            List<LogisticDTO> purchases = reader.lines().map(LogisticDTO::toDto).collect(Collectors.toList());
            
            LogisticData logisticData = logisticMapper.mapDtosToEntities(purchases);

            userRepository.saveAll(logisticData.getUsers());
            productRepository.saveAll(logisticData.getProducts());
            orderRepository.saveAll(logisticData.getOrders());
            productPurchasedRepository.saveAll(logisticData.getProductPurchased());     
   
        } catch (IOException e) {
        	throw new Exception("There has been a error on processing file: " + e.getMessage());
        } 
        
        
	}
	
	public List<PurchaseDTO> getAllPurchases(Long orderId, LocalDate startDate, LocalDate endDate){
		
		return userRepository.findFilteredPurchases(orderId, startDate, endDate).stream().map(PurchaseDTO::toDto).toList();
	}
	
}
