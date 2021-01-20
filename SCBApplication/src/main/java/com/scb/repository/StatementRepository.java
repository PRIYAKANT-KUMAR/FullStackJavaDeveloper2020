package com.scb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scb.entity.ACTransaction;

public interface StatementRepository extends JpaRepository<ACTransaction, Long>{

}
