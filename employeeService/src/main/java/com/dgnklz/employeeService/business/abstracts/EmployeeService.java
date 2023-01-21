package com.dgnklz.employeeService.business.abstracts;

import java.util.List;

import com.dgnklz.employeeService.business.dto.requests.employee.CreateEmployeeRequest;
import com.dgnklz.employeeService.business.dto.requests.employee.UpdateEmployeeRequest;
import com.dgnklz.employeeService.business.dto.responses.employee.CreateEmployeeResponse;
import com.dgnklz.employeeService.business.dto.responses.employee.GetAllEmployeesResponse;
import com.dgnklz.employeeService.business.dto.responses.employee.GetEmployeeResponse;
import com.dgnklz.employeeService.business.dto.responses.employee.UpdateEmployeeResponse;
import com.dgnklz.employeeService.core.results.DataResult;
import com.dgnklz.employeeService.core.results.Result;

public interface EmployeeService {
	DataResult<List<GetAllEmployeesResponse>> getAll();
	DataResult<GetEmployeeResponse> getById(int id);
	DataResult<CreateEmployeeResponse> create(CreateEmployeeRequest request);
	DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest request, int id);
	Result delete(int id);
}