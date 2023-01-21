package com.dgnklz.employeeService.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dgnklz.employeeService.business.abstracts.CompanyService;
import com.dgnklz.employeeService.business.constants.Messages;
import com.dgnklz.employeeService.business.dto.requests.company.CreateCompanyRequest;
import com.dgnklz.employeeService.business.dto.requests.company.UpdateCompanyRequest;
import com.dgnklz.employeeService.business.dto.responses.company.CreateCompanyResponse;
import com.dgnklz.employeeService.business.dto.responses.company.GetAllCompaniesResponse;
import com.dgnklz.employeeService.business.dto.responses.company.GetCompanyResponse;
import com.dgnklz.employeeService.business.dto.responses.company.UpdateCompanyResponse;
import com.dgnklz.employeeService.core.exceptions.BusinessException;
import com.dgnklz.employeeService.core.mapping.ModelMapperService;
import com.dgnklz.employeeService.core.results.DataResult;
import com.dgnklz.employeeService.core.results.Result;
import com.dgnklz.employeeService.core.results.SuccessDataResult;
import com.dgnklz.employeeService.core.results.SuccessResult;
import com.dgnklz.employeeService.dataAccess.abstracts.CompanyRepository;
import com.dgnklz.employeeService.entities.Company;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CompanyManager implements CompanyService {
	private ModelMapperService mapper;
	private CompanyRepository repository;
	
	@Override
	public DataResult<List<GetAllCompaniesResponse>> getAll() {
		List<Company> companies = repository.findAll();
		List<GetAllCompaniesResponse> responses = companies 
				.stream()
					.map(company -> mapper.forResponse().map(company, GetAllCompaniesResponse.class))
						.toList();
		return new SuccessDataResult<>(responses, Messages.Company.AllListed);
	}
	
	@Override
	public DataResult<GetCompanyResponse> getById(int id) {
		checkIfCompanyExistById(id);
		Company company = repository.findById(id).orElseThrow();
		GetCompanyResponse response = mapper.forResponse().map(company, GetCompanyResponse.class);
		return new SuccessDataResult<>(response, Messages.Company.ListedById);
	}
	
	@Override
	public DataResult<CreateCompanyResponse> create(CreateCompanyRequest request) {
		Company company = mapper.forRequest().map(request, Company.class);
		repository.save(company);
		CreateCompanyResponse response = mapper.forResponse().map(company, CreateCompanyResponse.class);
		return new SuccessDataResult<>(response, Messages.Company.Created);
	}
	
	@Override
	public DataResult<UpdateCompanyResponse> update(UpdateCompanyRequest request, int id) {
		checkIfCompanyExistById(id);
		Company company = mapper.forRequest().map(request, Company.class);
		company.setId(id);
		repository.save(company);
		UpdateCompanyResponse response = mapper.forResponse().map(company, UpdateCompanyResponse.class);
		return new SuccessDataResult<>(response, Messages.Company.Updated);
	}

	@Override
	public Result delete(int id) {
		checkIfCompanyExistById(id);
		repository.deleteById(id);
		return new SuccessResult(Messages.Company.Deleted);
	}
	
	/// DOMAIN RULES \\\
	
	private void checkIfCompanyExistById(int id) {
		if (!repository.existsById(id)) {
			throw new BusinessException(Messages.Company.NotExist);
		}
	}
	
}