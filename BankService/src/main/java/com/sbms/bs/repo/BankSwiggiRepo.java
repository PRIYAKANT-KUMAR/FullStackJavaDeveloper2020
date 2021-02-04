package com.sbms.bs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbms.bs.entity.SwiggiAccountDetail;

@Repository
public interface BankSwiggiRepo extends JpaRepository<SwiggiAccountDetail, Long>{

}
