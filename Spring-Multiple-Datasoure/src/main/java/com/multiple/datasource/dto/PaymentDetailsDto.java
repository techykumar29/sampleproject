package com.multiple.datasource.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetailsDto {
	
	private String cardNumber;
	private String cardName;
	private String expiry;
	private String cvv;

}
