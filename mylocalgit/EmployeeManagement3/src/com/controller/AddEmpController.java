package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Employee;
import com.service.EmployeeProjectService;


@Controller
public class AddEmpController {
	
	@Autowired
	private EmployeeProjectService service;

	@RequestMapping("/displayHome.htm")
	public ModelAndView displayHomePage()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/addemployeeform.htm")
	public ModelAndView displayAddEmployeeForm(ModelMap map)
	{
		ModelAndView mv=new ModelAndView();
		Employee employee=new Employee();
		mv.addObject("employee",employee);
		mv.setViewName("addEmployee");
		return mv;
	}
	
	@ModelAttribute("projectids")
	public Map<String,String> populateProject()
	{
		Map<String,String> map=new HashMap<String,String>();
		List<String> li=service.getAllProjects();
		for(String string:li)
		{
			map.put(string, string);
		}
		return map;
	}
	
	
	@RequestMapping("/insertemployee.htm")
	public ModelAndView addEmployee(@ModelAttribute Employee employee)
	{
		ModelAndView mv=new ModelAndView();
		try {
			int id=service.addEmployee(employee);
			mv.addObject("message","Employee added successfully!EmpId:"+id);
		} catch (Exception e) {
			mv.addObject("error",e.getMessage());
		}
		mv.setViewName("addEmployee");
		return mv;
	}
	
}
