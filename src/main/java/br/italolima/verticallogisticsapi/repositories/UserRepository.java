package br.italolima.verticallogisticsapi.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.italolima.verticallogisticsapi.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

	   @Query("SELECT u FROM User u " +
	           "JOIN FETCH u.orders o " +
	           "WHERE (:orderId IS NULL OR o.id = :orderId) " +
	           "AND (:startDate IS NULL OR o.date >= :startDate) " +
	           "AND (:endDate IS NULL OR o.date <= :endDate)")
	    List<User> findFilteredPurchases(
	            @Param("orderId") Long orderId,
	            @Param("startDate") LocalDate startDate,
	            @Param("endDate") LocalDate endDate
	    );
}
