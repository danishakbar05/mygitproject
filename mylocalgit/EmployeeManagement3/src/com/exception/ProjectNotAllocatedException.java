package com.exception;

public class ProjectNotAllocatedException extends Exception{
	
	public ProjectNotAllocatedException()
	{
		super("No project allocated to given employee");
	}

}
