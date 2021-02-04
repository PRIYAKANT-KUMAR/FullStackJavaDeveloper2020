package com.sbms.fos.service;

import java.util.List;

import com.sbms.fos.entity.OrderItem;

public interface FoodOrderService {

	List<OrderItem> addFoodItems(String addfoodItem);

}
