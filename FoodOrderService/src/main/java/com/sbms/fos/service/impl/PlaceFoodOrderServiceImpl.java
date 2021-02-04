package com.sbms.fos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

import com.sbms.fos.bank.feignclient.BankClient;
import com.sbms.fos.dto.OrderDTO;
import com.sbms.fos.repo.FoodOrderReposotiry;
import com.sbms.fos.repo.OrdersReposotory;
import com.sbms.fos.repo.PlaceFoodOrderServiceRepository;
import com.sbms.fos.service.PlaceFoodOrderService;

@EnableFeignClients
@Service
public class PlaceFoodOrderServiceImpl implements PlaceFoodOrderService {

	
	@Autowired
	private PlaceFoodOrderServiceRepository placeFoodOrderServiceRepository;
	
	@Autowired
	private FoodOrderReposotiry foodOrderReposotiry;
	
	@Autowired
	OrdersReposotory ordersReposotory;
	
	@Autowired
	private BankClient bankclient;

	@Override
	public String placeOrderItemDetail(OrderDTO orderDto) {//TODO
		return null;
	}

}
