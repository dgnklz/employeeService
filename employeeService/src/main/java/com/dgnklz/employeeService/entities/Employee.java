package com.dgnklz.employeeService.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private int id;
	
	@Column(name = "firstName")
    private String firstName;
	
	@Column(name = "lastName")
    private String lastName;
	
	@Column(name = "email")
    private String email;
    
    @Column(name = "position")
    private String position;
    
    @ManyToOne
	@JoinColumn(name="companyId")
	@OnDelete (action = OnDeleteAction.CASCADE)
	private Company company;
}