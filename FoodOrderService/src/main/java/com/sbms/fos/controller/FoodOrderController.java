package com.sbms.fos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sbms.fos.entity.OrderItem;
import com.sbms.fos.service.FoodOrderService;

@RestController
@RequestMapping("/food-order")
public class FoodOrderController {

	@Autowired
	private FoodOrderService foodItemService;

	@GetMapping("/add-food-items")
	public ResponseEntity<List<OrderItem>> addFoodItems(@RequestParam String addfoodItem) {

		return ResponseEntity.ok().body(foodItemService.addFoodItems(addfoodItem));
	}

}
