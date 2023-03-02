package com.project.enoca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.enoca.dto.CompanyCreateRequest;
import com.project.enoca.dto.CompanyUpdateRequest;
import com.project.enoca.entities.Company;
import com.project.enoca.entities.Employee;
import com.project.enoca.repository.CompanyRepository;


@Service
public class CompanyService {
	private CompanyRepository companyRepository; 
	private EmployeeService employeeService; 
	
	public CompanyService(CompanyRepository companyRepository, EmployeeService employeeService ) {
		this.companyRepository=companyRepository;
		this.employeeService = employeeService;
	}
	public Iterable<Company> getAllEmployee(Optional<Integer> employeeId) {
		if(employeeId.isPresent())
			return companyRepository.findByEmployeeId(employeeId.get());
		return companyRepository.findAll();
	}
	public Company getOneCompanyById(Integer companyId) {
		return companyRepository.findById(companyId).orElse(null); 
	}
	public Company createOneCompany(CompanyCreateRequest newCompanyDto) {
		Employee employee = employeeService.getOneEmployee(newCompanyDto.getId());
		if(employee == null) 	return null;
		Company toSave = new  Company();
		toSave.setId(newCompanyDto.getId());
		toSave.setName(newCompanyDto.getName());
		toSave.setAddress(newCompanyDto.getAddress());
		toSave.setEmployee(employee);
		return companyRepository.save(toSave);
	}
	public Company updateOneEmployeeById(Integer companyId, CompanyUpdateRequest updateCompany) {
		Optional<Company> company = companyRepository.findById(companyId);
		if(company.isPresent()) {
		Company toUpdate = company.get();
		toUpdate.setName(updateCompany.getName());
		toUpdate.setAddress(updateCompany.getAddress());
		companyRepository.save(toUpdate);
		return toUpdate;
		}else	return null;
	}
	public void deleteOneCompanyById(Integer companyId) {
		companyRepository.deleteById(companyId);
	}

}
