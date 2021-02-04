package com.sbms.fos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbms.fos.entity.OrderItem;

@Repository
public interface PlaceFoodOrderServiceRepository extends JpaRepository<OrderItem, Long> {

	

}
