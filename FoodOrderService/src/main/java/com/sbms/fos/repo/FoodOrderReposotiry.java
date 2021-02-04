package com.sbms.fos.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbms.fos.entity.OrderItem;

@Repository
public interface FoodOrderReposotiry extends JpaRepository<OrderItem, Long> {

	List<OrderItem> findByFoodItemContains(String foodItem);

}
