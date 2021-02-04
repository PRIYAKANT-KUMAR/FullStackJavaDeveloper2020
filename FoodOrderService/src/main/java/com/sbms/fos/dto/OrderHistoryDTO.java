package com.sbms.fos.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrderHistoryDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long orderId;
	private Long userId;
	private Long totalAmount;
	private LocalDateTime orderedDate;

}
