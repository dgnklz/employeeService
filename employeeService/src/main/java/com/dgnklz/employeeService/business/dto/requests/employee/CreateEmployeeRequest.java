package com.dgnklz.employeeService.business.dto.requests.employee;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.dgnklz.employeeService.business.constants.Regex;
import com.dgnklz.employeeService.business.constants.ValidationMessages;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CreateEmployeeRequest {
	@NotBlank(message = ValidationMessages.Employee.EmployeeNameBlank)
    @Length(min = 2, max = 10, message = ValidationMessages.Employee.EmployeeNameLength)
	private String firstName;
	
	@NotBlank(message = ValidationMessages.Employee.EmployeeLastNameBlank)
    @Length(min = 2, max = 10, message = ValidationMessages.Employee.EmployeeLastNameLength)
	private String lastName;
	
	@NotBlank(message = ValidationMessages.Employee.EmployeeEmailBlank)
    @Email(regexp = Regex.Email, message = ValidationMessages.Employee.EmployeeEmailValid)
	private String email;
	
	@NotBlank(message = ValidationMessages.Employee.EmployeePositionBlank)
    @Length(min = 2, max = 20, message = ValidationMessages.Employee.EmployeePositionLength)
	private String position;
	
	@Min(value = 1, message = ValidationMessages.Employee.EmployeeCompanyIdBlank)
	private int companyId;
}