package com.exception;

public class EmployeeNotFoundException extends Exception{
	
	public EmployeeNotFoundException()
	{
		super("Employee does not exists");
	}

}
