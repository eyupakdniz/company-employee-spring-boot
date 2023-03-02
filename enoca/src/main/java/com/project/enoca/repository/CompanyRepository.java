package com.project.enoca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.enoca.entities.Company;

@Repository
/*public interface CompanyRepository extends JpaRepository<Company, Integer> {*/
	public interface CompanyRepository extends CrudRepository<Company, Integer> {
	
	

	List<Company> findByEmployeeId(Integer employeeId);

}
