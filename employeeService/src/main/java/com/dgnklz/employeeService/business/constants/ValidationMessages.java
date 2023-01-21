package com.dgnklz.employeeService.business.constants;

public class ValidationMessages {
	public static class Company {
		public static final String CompanyNameBlank = "Company Name is required";
		public static final String CompanyNameLength = "Company Name characters must be between 2 and 20";
	}
	
	public static class Employee {
		public static final String EmployeeNameBlank = "Employee Name is required";
		public static final String EmployeeNameLength = "Employee Name characters must be between 2 and 10";
		
		public static final String EmployeeLastNameBlank = "Employee Last Name is required";
		public static final String EmployeeLastNameLength = "Employee Last Name characters must be between 2 and 10";
		
		public static final String EmployeeEmailBlank = "Employee Email is required";
		public static final String EmployeeEmailValid = "Employee Email must be valid";
		
		public static final String EmployeePositionBlank = "Employee Position is required";
		public static final String EmployeePositionLength = "Employee Position characters must be between 2 and 20";
		
		public static final String EmployeeCompanyIdBlank = "Company Id is required";
	}
	
}