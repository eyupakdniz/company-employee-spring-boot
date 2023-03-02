package com.project.enoca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.enoca.entities.Employee;

/*@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}*/
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	List<Employee> findByEmployeeId();
}
