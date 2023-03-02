package com.project.enoca.controller;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.enoca.dto.EmployeeUpdateRequest;
import com.project.enoca.entities.Employee;
import com.project.enoca.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	@GetMapping
	public List<Employee> getAllEmployee(){
		return (List<Employee>) employeeService.getAllEmployees();
	}
	@PostMapping("/create")
	public Employee createEmployee(@RequestBody Employee newEmployee) {
		return employeeService.saveOneEmployee(newEmployee);
	}
	@GetMapping("/{employeeId}")
	public Employee getOneEmployee(@PathVariable Integer employeeId) {
		//custom exception
		return employeeService.getOneEmployee(employeeId);
	}
	@PutMapping("/update")
	public Employee updateOneEmployee(@PathVariable Integer employeeId, 
			@RequestBody EmployeeUpdateRequest newEmployee) {
		return employeeService.updateOneEmployee(employeeId, newEmployee);
	}
	@DeleteMapping("/delete")
	public void deleteOneEmployee(@PathVariable Integer employeeId) {
		employeeService.deleteById(employeeId);
	}
	}
