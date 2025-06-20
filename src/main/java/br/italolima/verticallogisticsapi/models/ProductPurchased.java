package br.italolima.verticallogisticsapi.models;

import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_purchased")
public class ProductPurchased {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen")
	@JsonIgnore
	private Long id;
	
	private BigDecimal price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	@JsonIgnore
	private Order order;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal value) {
		this.price = value;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductPurchased productPurchased = (ProductPurchased) o;
        
        return id.equals(productPurchased.id) && 
        		price.equals(productPurchased.price) && 
        		order.getId().equals(productPurchased.getOrder().getId()) && 
        		product.getId().equals(productPurchased.getProduct().getId());
    }
	
    @Override
    public int hashCode() {
        return Objects.hash(id, price);
    }
	
}
