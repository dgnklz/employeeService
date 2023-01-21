package com.dgnklz.employeeService.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dgnklz.employeeService.entities.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{
}