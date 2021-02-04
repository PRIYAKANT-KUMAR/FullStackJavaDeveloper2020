package com.sbms.fos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbms.fos.entity.OrderHistory;

@Repository
public interface FoodOrderHistoryRepository extends JpaRepository<OrderHistory, Long> {

}
