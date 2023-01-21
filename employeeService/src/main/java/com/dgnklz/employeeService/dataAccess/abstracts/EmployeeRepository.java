package com.dgnklz.employeeService.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dgnklz.employeeService.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
}