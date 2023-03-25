package com.multiple.datasource.entity.orders;

import java.security.Timestamp;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDER_DETAILS")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrderDetails {
	
	@Id
	@GeneratedValue
	private long id;
	private String quantity;
	private String price;
	@CreationTimestamp
	private Date created;
	@UpdateTimestamp
	private Date updated;

}
