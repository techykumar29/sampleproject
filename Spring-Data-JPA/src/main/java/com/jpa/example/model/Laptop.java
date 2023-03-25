package com.jpa.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="LAPTOP")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Laptop {
	
	@Id
	@GeneratedValue
	private long id;
	private String brand;
	private String name;
	
	@ManyToOne
	Student student;

}
