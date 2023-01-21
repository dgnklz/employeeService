package com.dgnklz.employeeService.business.abstracts;

import com.dgnklz.employeeService.business.dto.requests.company.CreateCompanyRequest;
import com.dgnklz.employeeService.business.dto.requests.company.UpdateCompanyRequest;
import com.dgnklz.employeeService.business.dto.responses.company.CreateCompanyResponse;
import com.dgnklz.employeeService.business.dto.responses.company.GetAllCompaniesResponse;
import com.dgnklz.employeeService.business.dto.responses.company.GetCompanyResponse;
import com.dgnklz.employeeService.business.dto.responses.company.UpdateCompanyResponse;
import com.dgnklz.employeeService.core.results.DataResult;
import com.dgnklz.employeeService.core.results.Result;

import java.util.List;

public interface CompanyService {
	DataResult<List<GetAllCompaniesResponse>> getAll();
	DataResult<GetCompanyResponse> getById(int id);
	DataResult<CreateCompanyResponse> create(CreateCompanyRequest request);
	DataResult<UpdateCompanyResponse> update(UpdateCompanyRequest request, int id);
	Result delete(int id);
}