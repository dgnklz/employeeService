package com.dgnklz.employeeService.business.dto.responses.employee;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class GetEmployeeResponse {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
    private String position;
    private int companyId;
}