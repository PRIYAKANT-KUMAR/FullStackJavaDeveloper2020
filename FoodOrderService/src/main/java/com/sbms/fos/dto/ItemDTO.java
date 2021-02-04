package com.sbms.fos.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ItemDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String itemName;
	private Integer price;
	private Integer quantity;

}
