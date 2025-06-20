package br.italolima.verticallogisticsapi.mappers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.italolima.verticallogisticsapi.dtos.LogisticDTO;
import br.italolima.verticallogisticsapi.models.Order;
import br.italolima.verticallogisticsapi.models.Product;
import br.italolima.verticallogisticsapi.models.ProductPurchased;
import br.italolima.verticallogisticsapi.models.User;

@Component
public class LogisticMapper {
	
    private Map<Long, User> userCache;
    private Map<Long, Order> orderCache;
    private Map<Long, Product> productCache;
    
	private Set<Product> productsSet;
    private Set<Order> ordersSet;
    private Set<User> usersSet;
    private List<ProductPurchased> productsPurchasedList;

	public LogisticData mapDtosToEntities(List<LogisticDTO> dtos) {
		userCache = new HashMap<>();
		orderCache = new HashMap<>();
		productCache = new HashMap<>();
		
		productsSet = new HashSet<>();
	    ordersSet = new HashSet<>();
	    usersSet = new HashSet<>();
		
		productsPurchasedList = dtos.stream()
            .map(this::mapSingleDto)
            .collect(Collectors.toList());
		
        return new LogisticData(
    		new ArrayList<>(usersSet),
            new ArrayList<>(ordersSet),
            new ArrayList<>(productsSet),
            productsPurchasedList
        );
    }
	
	public ProductPurchased mapSingleDto(LogisticDTO dto) {
		
        User user = userCache.computeIfAbsent(dto.userId(), id -> {
            User newUser = new User();
            newUser.setId(id);
            usersSet.add(newUser);
            return newUser;
        });
		
        user.setName(dto.userName());
        
        Order order = orderCache.computeIfAbsent(dto.orderId(), id -> {
            Order newOrder = new Order();
            newOrder.setId(id);
            ordersSet.add(newOrder);
            return newOrder;
        });
        
        order.setDate(dto.date());
        order.setUser(user);
        
        
        if (!user.getOrders().contains(order)) {
            user.getOrders().add(order);
        }
        
        Product product = productCache.computeIfAbsent(dto.productId(), id -> {
            Product newProduct = new Product();
            newProduct.setId(id);
            productsSet.add(newProduct);
            return newProduct;
        });
        

		ProductPurchased productPurchase = new ProductPurchased();

        productPurchase.setOrder(order);
        productPurchase.setProduct(product);
        productPurchase.setAmount(dto.amount());     
        
        order.getProductPurchased().add(productPurchase);

		return productPurchase;
	}

	public static class LogisticData {
        private final List<User> users;
        private final List<Order> orders;
        private final List<Product> products;
        private final List<ProductPurchased> productPurchased;

        public LogisticData(List<User> users, List<Order> orders, List<Product> products, List<ProductPurchased> productPurchased) {
            this.users = users;
            this.orders = orders;
            this.products = products;
            this.productPurchased = productPurchased;
        }

        public List<User> getUsers() { return users; }
        public List<Order> getOrders() { return orders; }
        public List<Product> getProducts() { return products; }
        public List<ProductPurchased> getProductPurchased() { return productPurchased; }
    }
}


