package com.sbms.bs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sbms.bs.entity.SwiggiAccountDetail;
import com.sbms.bs.entity.UserAccountDetail;
import com.sbms.bs.repo.BankSwiggiRepo;
import com.sbms.bs.repo.BankUserRepo;
import com.sbms.bs.service.BankService;

@Repository
public class BankServiceImpl implements BankService{
	
	@Autowired
	private BankUserRepo bankUserRepo;
	
	@Autowired
	BankSwiggiRepo bankSwiggiRepo;

	@Override
	public String createUserAccount(UserAccountDetail userAccountDetail) {
		
		UserAccountDetail userAccountDetail1 = bankUserRepo.save(userAccountDetail);
		
		return "Congratulations "+userAccountDetail1.getUserName()+"!! your User account Number is created : " + userAccountDetail1.getUserAccountNumber();		
	}
	
	public String createSwiggiAccount(SwiggiAccountDetail swiggiAccountDetail) {
		
		SwiggiAccountDetail swiggiAccountDetail1 = bankSwiggiRepo.save(swiggiAccountDetail);
		
		return "Congratulations "+swiggiAccountDetail1.getSwiggiName()+"!! your Swiggi account Number is created : " + swiggiAccountDetail1.getSwiggiAccountNumber();
	}

}
