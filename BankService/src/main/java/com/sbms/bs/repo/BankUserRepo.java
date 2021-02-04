package com.sbms.bs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbms.bs.entity.UserAccountDetail;

@Repository
public interface BankUserRepo extends JpaRepository<UserAccountDetail, Long>{
	
	

}
