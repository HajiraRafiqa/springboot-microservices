package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;




@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	private EmployeeRepository employeeRepository;
	
	//get all employee 
	
	@GetMapping("/employees")
	public List<Employee> getAll()
	{
		System.out.print("here");
		return employeeRepository.findAll();
	}

}
