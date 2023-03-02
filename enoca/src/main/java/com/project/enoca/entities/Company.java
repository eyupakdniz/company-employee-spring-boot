package com.project.enoca.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@EntityScan
@Entity 
@Table(name = "companies")
@Data 
@AllArgsConstructor
@NoArgsConstructor
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	
	@Column(nullable = false, name="name")
	String name;
	@Column(nullable = false, name="address")
	String address;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="employee_id",nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	Employee employee;

}