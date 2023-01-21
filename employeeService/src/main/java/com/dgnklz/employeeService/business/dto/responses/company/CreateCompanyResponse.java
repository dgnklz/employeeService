package com.dgnklz.employeeService.business.dto.responses.company;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CreateCompanyResponse {
	private int id;
	private String companyName;
}