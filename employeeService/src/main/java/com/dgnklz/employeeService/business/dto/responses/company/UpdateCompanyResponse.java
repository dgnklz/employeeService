package com.dgnklz.employeeService.business.dto.responses.company;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UpdateCompanyResponse {
	private int id;
	private String companyName;
}