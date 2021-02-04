package com.sbms.fos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbms.fos.entity.Order;

@Repository
public interface OrdersReposotory extends JpaRepository<Order, Long> {

}
