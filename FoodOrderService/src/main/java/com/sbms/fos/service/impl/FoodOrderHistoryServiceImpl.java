package com.sbms.fos.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbms.fos.entity.OrderHistory;
import com.sbms.fos.repo.FoodOrderHistoryRepository;
import com.sbms.fos.service.FoodOrderHistoryService;

@Service
public class FoodOrderHistoryServiceImpl implements FoodOrderHistoryService {

	@Autowired
	FoodOrderHistoryRepository FoodOrderHistoryRepository;

	@Override
	public List<OrderHistory> getLatestTxHistory() {
		return FoodOrderHistoryRepository.findAll().stream().sorted(Comparator.comparingLong(OrderHistory::getOrderId))
				.collect(Collectors.toList()).subList(0, 5);
	}

}
