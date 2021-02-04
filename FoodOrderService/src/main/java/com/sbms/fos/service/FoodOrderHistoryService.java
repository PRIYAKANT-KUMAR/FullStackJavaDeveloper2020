package com.sbms.fos.service;

import java.util.List;

import com.sbms.fos.entity.OrderHistory;

public interface FoodOrderHistoryService {

	List<OrderHistory> getLatestTxHistory();

}
