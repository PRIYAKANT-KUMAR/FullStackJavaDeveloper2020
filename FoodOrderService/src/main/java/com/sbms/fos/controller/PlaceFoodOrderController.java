package com.sbms.fos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbms.fos.dto.OrderDTO;
import com.sbms.fos.service.PlaceFoodOrderService;

@RestController
@RequestMapping("/place-food-order")
public class PlaceFoodOrderController {

	@Autowired
	private PlaceFoodOrderService placeFoodOrderService;

	@PostMapping("/order-food-item")
	public ResponseEntity<String> placeOrder(@RequestBody OrderDTO orderDto) {

		return ResponseEntity.ok().body(placeFoodOrderService.placeOrderItemDetail(orderDto));
	}

}
