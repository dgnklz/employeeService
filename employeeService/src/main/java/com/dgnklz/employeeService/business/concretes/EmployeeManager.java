package com.dgnklz.employeeService.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dgnklz.employeeService.business.abstracts.CompanyService;
import com.dgnklz.employeeService.business.abstracts.EmployeeService;
import com.dgnklz.employeeService.business.constants.Messages;
import com.dgnklz.employeeService.business.dto.requests.employee.CreateEmployeeRequest;
import com.dgnklz.employeeService.business.dto.requests.employee.UpdateEmployeeRequest;
import com.dgnklz.employeeService.business.dto.responses.employee.CreateEmployeeResponse;
import com.dgnklz.employeeService.business.dto.responses.employee.GetAllEmployeesResponse;
import com.dgnklz.employeeService.business.dto.responses.employee.GetEmployeeResponse;
import com.dgnklz.employeeService.business.dto.responses.employee.UpdateEmployeeResponse;
import com.dgnklz.employeeService.core.exceptions.BusinessException;
import com.dgnklz.employeeService.core.mapping.ModelMapperService;
import com.dgnklz.employeeService.core.results.DataResult;
import com.dgnklz.employeeService.core.results.Result;
import com.dgnklz.employeeService.core.results.SuccessDataResult;
import com.dgnklz.employeeService.core.results.SuccessResult;
import com.dgnklz.employeeService.dataAccess.abstracts.EmployeeRepository;
import com.dgnklz.employeeService.entities.Employee;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeManager implements EmployeeService {
	private ModelMapperService mapper;
	private EmployeeRepository repository;
	private CompanyService companyService;
	
	@Override
	public DataResult<List<GetAllEmployeesResponse>> getAll() {
		List<Employee> employees = repository.findAll();
		List<GetAllEmployeesResponse> responses = employees 
				.stream()
					.map(employee -> mapper.forResponse().map(employee, GetAllEmployeesResponse.class))
						.toList();
		return new SuccessDataResult<>(responses, Messages.Employee.AllListed);
	}
	
	@Override
	public DataResult<GetEmployeeResponse> getById(int id) {
		checkIfEmployeeExistById(id);
		Employee employee = repository.findById(id).orElseThrow();
		GetEmployeeResponse response = mapper.forResponse().map(employee, GetEmployeeResponse.class);
		return new SuccessDataResult<>(response, Messages.Employee.ListedById);
	}
	
	@Override
	public DataResult<CreateEmployeeResponse> create(CreateEmployeeRequest request) {
		checkIfCompanyExistById(request.getCompanyId());
		Employee employee = mapper.forRequest().map(request, Employee.class);
		employee.setId(0);
		repository.save(employee);
		CreateEmployeeResponse response = mapper.forResponse().map(employee, CreateEmployeeResponse.class);
		return new SuccessDataResult<>(response, Messages.Employee.Created);
	}
	
	@Override
	public DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest request, int id) {
		checkIfEmployeeExistById(id);
		checkIfCompanyExistById(request.getCompanyId());
		Employee employee = mapper.forRequest().map(request, Employee.class);
		employee.setId(id);
		repository.save(employee);
		UpdateEmployeeResponse response = mapper.forResponse().map(employee, UpdateEmployeeResponse.class);
		return new SuccessDataResult<>(response, Messages.Employee.Updated);
	}
	
	@Override
	public Result delete(int id) {
		checkIfEmployeeExistById(id);
		repository.deleteById(id);
		return new SuccessResult(Messages.Employee.Deleted);
	}
	
	/// DOMAIN RULES \\\
	
	private void checkIfEmployeeExistById(int id) {
		if (!repository.existsById(id)) {
			throw new BusinessException(Messages.Employee.NotExist);
		}
	}
	
	private void checkIfCompanyExistById(int companyId) {
		companyService.getById(companyId);
	}
}