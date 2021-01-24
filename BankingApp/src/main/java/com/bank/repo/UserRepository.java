package com.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.entity.UserDetail;

@Repository
public interface UserRepository extends JpaRepository<UserDetail, Long>{
	
}
