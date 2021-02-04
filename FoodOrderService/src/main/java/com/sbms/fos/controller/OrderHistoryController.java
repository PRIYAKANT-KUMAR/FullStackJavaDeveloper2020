package com.sbms.fos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbms.fos.entity.OrderHistory;
import com.sbms.fos.service.FoodOrderHistoryService;

@RestController
@RequestMapping("/order-tx-history")
public class OrderHistoryController {

	@Autowired
	private FoodOrderHistoryService foodOrderHistoryService;

	@GetMapping("/get-latest-order-detail")
	public ResponseEntity<List<OrderHistory>> getLatestDetail() {

		return ResponseEntity.ok().body(foodOrderHistoryService.getLatestTxHistory());

	}
}
