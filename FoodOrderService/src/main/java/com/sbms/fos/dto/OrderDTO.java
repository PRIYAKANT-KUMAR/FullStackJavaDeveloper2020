package com.sbms.fos.dto;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Data;

@Data
public class OrderDTO implements Serializable{
	 
	private static final long serialVersionUID = 1L;

	private ArrayList<ItemDTO> orderItemDetails;
	private Long userId;
	private String foodVendorAcountNumber;
	
	
}
