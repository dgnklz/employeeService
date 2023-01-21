package com.dgnklz.employeeService.business.dto.requests.company;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.dgnklz.employeeService.business.constants.ValidationMessages;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CreateCompanyRequest {
	@NotBlank(message = ValidationMessages.Company.CompanyNameBlank)
    @Length(min = 2, max = 20, message = ValidationMessages.Company.CompanyNameLength)
	private String companyName;
}