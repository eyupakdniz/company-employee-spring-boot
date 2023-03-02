package com.project.enoca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.project.enoca.dto.EmployeeCreateRequest;
import com.project.enoca.dto.EmployeeUpdateRequest;
import com.project.enoca.entities.Company;
import com.project.enoca.entities.Employee;
import com.project.enoca.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;
	private CompanyService companySerive;
	
	public EmployeeService(EmployeeRepository employeeRepository,CompanyService companySerive) {
		this.employeeRepository = employeeRepository;
		this.companySerive = companySerive;
	}
	public List<Employee> getAllEmployees(Optional<Integer> companyId) {
		if(companyId.isPresent())
			return employeeRepository.findByEmployeeId();
		return (List<Employee>) employeeRepository.findAll();
	}
	public Employee saveOneEmployee(Employee newEmployee) {
		return employeeRepository.save(newEmployee);
	}
	public Employee getOneEmployee(Integer employeeId) {
		return employeeRepository.findById(employeeId).orElse(null);
		
	}
	public Employee createOneEmployee(EmployeeCreateRequest newEmployeeDto) {
		Company company = companySerive.getOneCompany(newEmployeeDto.getId());
		if(company == null) 	return null;
		Company toSave = new  Company();
		toSave.setId(newEmployeeDto.getId());
		toSave.setName(newEmployeeDto.getName());
		toSave.setName(newEmployeeDto.getTitle());
		toSave.setCompany(company);
		return companySerive.save(toSave);
	}
	public Employee updateOneEmployee(Integer employeeId, EmployeeUpdateRequest updateEmployee) {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if(employee.isPresent()) {
			Employee foundEmployee = employee.get();
			foundEmployee.setName(updateEmployee.getName());
			foundEmployee.setTitle(updateEmployee.getTitle());
			employeeRepository.save(foundEmployee);
			return foundEmployee;
		}else
		return null;
	}
	public void deleteById(Integer employeeId) {
		employeeRepository.deleteById(employeeId);
	}	
}
