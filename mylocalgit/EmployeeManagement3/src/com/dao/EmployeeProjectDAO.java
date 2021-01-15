package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Employee;
import com.bean.Project;
import com.entity.EmployeeEntity;
import com.entity.ProjectEntity;


@Component
public class EmployeeProjectDAO {
	
	@PersistenceContext
	EntityManager em;	
	
	public List<String> getAllProjects()
	{
		Query q=em.createQuery("select p.projectId from ProjectEntity p");
		List<String> li=q.getResultList();		
		return li;
	}
	
	public Project getProjectDetails(String projectId)
	{
		ProjectEntity pe=em.find(ProjectEntity.class, projectId);
		Project p=new Project();
		p.setProjectId(pe.getProjectId());
		p.setTechnology(pe.getTechnology());
		p.setResourceCount(pe.getResourceCount());
		return p;
		
	}
	
	@Transactional
	public Integer addEmployee(Employee emp)
	{
		EmployeeEntity ee=new EmployeeEntity();		
		ee.setEmployeeName(emp.getEmployeeName());
		ee.setGender(emp.getGender());
		ee.setSkill(emp.getSkill());
		ProjectEntity pe=em.find(ProjectEntity.class, emp.getProjectId());
		ee.setProject(pe);
		em.persist(ee);
		pe.setResourceCount(pe.getResourceCount()+1);
		int empId=ee.getEmployeeId();
		return empId;
	}
	
	
	public int getEmployeeStatus(Integer empId)
	{
		EmployeeEntity ee=em.find(EmployeeEntity.class, empId);
		
		if(ee==null)
		{
			return 0;
		}
		else
		{
			if(ee.getProject()==null)
			{
				return 1;
			}
		}
		return -1;
	}
	
	@Transactional
	public void deallocateEmployee(Integer empId)
	{
		EmployeeEntity ee=em.find(EmployeeEntity.class, empId);
		ProjectEntity pe=ee.getProject();
		pe.setResourceCount(pe.getResourceCount()-1);
		ee.setProject(null);
		
	}
	
	public List<Employee> getEmployeeDetails()
	{
		Query q=em.createQuery("select e from EmployeeEntity e");
		List<EmployeeEntity> ee=q.getResultList();
		List<Employee> eml=new ArrayList<Employee>();
		
		for(EmployeeEntity empent:ee)
		{
			Employee em=new Employee();
			em.setEmployeeId(empent.getEmployeeId());
			em.setEmployeeName(empent.getEmployeeName());
			em.setGender(empent.getGender());
			em.setSkill(empent.getSkill());
			
			if(empent.getProject()==null)
			{
				em.setProjectId(null);
			}
			else
			{
				em.setProjectId(empent.getProject().getProjectId());
			}
			eml.add(em);
		}
		return eml;
	}


}
