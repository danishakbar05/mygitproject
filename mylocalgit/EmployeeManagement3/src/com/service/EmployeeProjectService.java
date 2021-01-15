package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bean.Employee;
import com.bean.Project;
import com.dao.EmployeeProjectDAO;
import com.exception.EmployeeNotFoundException;
import com.exception.NoResourceException;
import com.exception.ProjectNotAllocatedException;
import com.exception.SkillMismatchException;


@Component
public class EmployeeProjectService {
	
	
	@Autowired
	private EmployeeProjectDAO dao;
	
	
	public Integer addEmployee(Employee employee) throws Exception
	{
		Project p=dao.getProjectDetails(employee.getProjectId());
		System.out.println(employee.getSkill()+" "+p.getTechnology());
		if(!employee.getSkill().equals(p.getTechnology()))
		{
			throw new SkillMismatchException();
		}
		if(p.getResourceCount()==10)
		{
			throw new NoResourceException();
		}
		Integer eid=dao.addEmployee(employee);
		return eid;
	}
	
	public List<String> getAllProjects()
	{
		
		
		return dao.getAllProjects();
	}
	
	public void deallocateEmployee(int employeeId) throws Exception
	{
		int status=dao.getEmployeeStatus(employeeId);
		if(status==0)
		{
			throw new EmployeeNotFoundException();
		}
		else if(status==1)
		{
			throw new ProjectNotAllocatedException();
		}
		else
		{
			dao.deallocateEmployee(employeeId);
		}
	}
	
	public List<Employee> getEmployeeDetails()
	{
		return dao.getEmployeeDetails();
	}

}
