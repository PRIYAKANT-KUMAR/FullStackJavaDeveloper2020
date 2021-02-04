package com.sbms.fos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbms.fos.entity.OrderItem;
import com.sbms.fos.repo.FoodOrderReposotiry;
import com.sbms.fos.service.FoodOrderService;

@Service
public class FoodOrderServiceImpl implements FoodOrderService {

	@Autowired
	private FoodOrderReposotiry foodOrderReposotiry;

	@Override
	public List<OrderItem> addFoodItems(String addfoodItem) {
		return foodOrderReposotiry.findByFoodItemContains(addfoodItem);
	}

}
