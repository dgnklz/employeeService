package com.dgnklz.employeeService.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dgnklz.employeeService.business.abstracts.EmployeeService;
import com.dgnklz.employeeService.business.dto.requests.employee.CreateEmployeeRequest;
import com.dgnklz.employeeService.business.dto.requests.employee.UpdateEmployeeRequest;
import com.dgnklz.employeeService.business.dto.responses.employee.CreateEmployeeResponse;
import com.dgnklz.employeeService.business.dto.responses.employee.GetAllEmployeesResponse;
import com.dgnklz.employeeService.business.dto.responses.employee.GetEmployeeResponse;
import com.dgnklz.employeeService.business.dto.responses.employee.UpdateEmployeeResponse;
import com.dgnklz.employeeService.core.results.DataResult;
import com.dgnklz.employeeService.core.results.Result;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	private EmployeeService service;
	
	@GetMapping
	public DataResult<List<GetAllEmployeesResponse>> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public DataResult<GetEmployeeResponse> getById(@PathVariable int id) {
		return service.getById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public DataResult<CreateEmployeeResponse> create(@Valid @RequestBody CreateEmployeeRequest request) {
		return service.create(request);
	}
	
	@PutMapping("/{id}")
	public DataResult<UpdateEmployeeResponse> update(@Valid @RequestBody UpdateEmployeeRequest request, @PathVariable int id) {
		return service.update(request, id);
	}
	
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return service.delete(id);
	}
}