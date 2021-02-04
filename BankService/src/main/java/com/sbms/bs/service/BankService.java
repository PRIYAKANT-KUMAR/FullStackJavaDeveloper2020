package com.sbms.bs.service;

import com.sbms.bs.entity.SwiggiAccountDetail;
import com.sbms.bs.entity.UserAccountDetail;

public interface BankService {

	String createUserAccount(UserAccountDetail userAccountDetail);
	
	String createSwiggiAccount(SwiggiAccountDetail swiggiAccountDetail);

}
