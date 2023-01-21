package com.dgnklz.employeeService.core.exceptions;

public class BusinessException extends RuntimeException{
	public BusinessException(String message) {
		super(message);
	}
}