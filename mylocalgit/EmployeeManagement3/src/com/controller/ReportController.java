package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Employee;
import com.service.EmployeeProjectService;

@Controller
public class ReportController {
	
	@Autowired
	private EmployeeProjectService service;
	
	@RequestMapping("/employeereportform.htm")
	public ModelAndView employeeReport()
	{
		ModelAndView mv=new ModelAndView();
		List <Employee> emp=service.getEmployeeDetails();
		
		mv.addObject("Employee" , emp);
		mv.setViewName("report");		
		return mv;
	}

}
