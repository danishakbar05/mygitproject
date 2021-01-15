package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Employee;
import com.service.EmployeeProjectService;

@Controller
public class DeallocateEmpController {
	
	@Autowired
	private EmployeeProjectService service;
	
	@RequestMapping("/deallocateemployeeform.htm")
	public ModelAndView displayDeallocateEmployeeForm()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("deallocateEmployee");
		return mv;
	}
	
	@RequestMapping("/deallocateemployee.htm")
	public ModelAndView deallocateEmployee(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();		
		String id=request.getParameter("empid");
		try {
			service.deallocateEmployee(Integer.parseInt(id));
			mv.addObject("message","Employee Deallocated Successfully");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			mv.addObject("error","Employee Id should be a number");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			mv.addObject("error",e.getMessage());
		}
		mv.setViewName("deallocateEmployee");						
		return mv;
	}

}
