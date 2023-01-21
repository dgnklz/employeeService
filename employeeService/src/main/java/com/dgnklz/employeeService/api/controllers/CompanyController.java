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

import com.dgnklz.employeeService.business.abstracts.CompanyService;
import com.dgnklz.employeeService.business.dto.requests.company.CreateCompanyRequest;
import com.dgnklz.employeeService.business.dto.requests.company.UpdateCompanyRequest;
import com.dgnklz.employeeService.business.dto.responses.company.CreateCompanyResponse;
import com.dgnklz.employeeService.business.dto.responses.company.GetAllCompaniesResponse;
import com.dgnklz.employeeService.business.dto.responses.company.GetCompanyResponse;
import com.dgnklz.employeeService.business.dto.responses.company.UpdateCompanyResponse;
import com.dgnklz.employeeService.core.results.DataResult;
import com.dgnklz.employeeService.core.results.Result;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/companies")
public class CompanyController {
	private CompanyService service;
	
	@GetMapping
	public DataResult<List<GetAllCompaniesResponse>> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public DataResult<GetCompanyResponse> getById(@PathVariable int id) {
		return service.getById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public DataResult<CreateCompanyResponse> create(@Valid @RequestBody CreateCompanyRequest request) {
		return service.create(request);
	}
	
	@PutMapping("/{id}")
	public DataResult<UpdateCompanyResponse> update(@Valid @RequestBody UpdateCompanyRequest request, @PathVariable int id) {
		return service.update(request, id);
	}
	
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return service.delete(id);
	}
}