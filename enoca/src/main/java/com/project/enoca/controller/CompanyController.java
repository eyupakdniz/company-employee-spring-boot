package com.project.enoca.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.enoca.dto.CompanyCreateRequest;
import com.project.enoca.dto.CompanyUpdateRequest;
import com.project.enoca.entities.Company;
import com.project.enoca.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	private CompanyService companySerivce;
	
	public CompanyController(CompanyService companySerivce) {
		this.companySerivce = companySerivce;
	}
	@GetMapping
	public List<Company> getAllCompanys(@RequestParam Optional<Integer> employeeId){
		return (List<Company>) companySerivce.getAllEmployee(employeeId);
	}
	@PostMapping("/create") 
	public Company createOneCompany(@RequestParam CompanyCreateRequest newCompanyDto) {
		return companySerivce.createOneCompany(newCompanyDto);
	}
	@GetMapping("/{companyId}")
	public Company getOneCompany(@PathVariable Integer companyId) {
		return companySerivce.getOneCompanyById(companyId);
	}
	@PutMapping("/update")
	public Company updateOneCompany(@PathVariable Integer companyId, 
			@RequestBody CompanyUpdateRequest updateCompany) {
		return companySerivce.updateOneEmployeeById(companyId, updateCompany);
		
	}
	@DeleteMapping("/delete")
	public void deleteOneCompany(@PathVariable Integer companyId) {
		companySerivce.deleteOneCompanyById(companyId);
	}
}
