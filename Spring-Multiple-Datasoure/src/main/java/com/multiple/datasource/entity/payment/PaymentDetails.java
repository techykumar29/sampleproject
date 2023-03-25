package com.multiple.datasource.entity.payment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PAYMENT_DETAILS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetails {

	@Id
	@GeneratedValue
	private long id;
	private String cardNumber;
	private String cardName;
	private String expiry;
	private String cvv;
}
