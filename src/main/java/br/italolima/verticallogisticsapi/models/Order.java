package br.italolima.verticallogisticsapi.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	private Long id;
	
	private LocalDate date;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
	@JsonIgnore
	private User user;
	
	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
	private List<ProductPurchased> productPurchased = new ArrayList<>();

	public Long getId() {
		return id;
	}
	public void setId(Long orderId) {
		this.id = orderId;
	}
	
	public BigDecimal getTotal() {			
		return this.productPurchased.stream().map(ProductPurchased::getPrice).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public List<ProductPurchased> getProductPurchased() {
		return productPurchased;
	}
	public void setProductPurchased(List<ProductPurchased> productPurchased) {
		this.productPurchased = productPurchased;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id) && date.equals(order.date);
    }
	
    @Override
    public int hashCode() {
        return Objects.hash(id, date, user);
    }
}
