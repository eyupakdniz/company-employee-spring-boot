package com.interview.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interview.demo.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
