package com.example.joinspring.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.joinspring.v1.DeptEmpDto;
import com.example.joinspring.v1.model.emp;

public interface EmployeeRepository extends JpaRepository<emp, Integer>{

	@Query("SELECT new com.example.joinspring.v1.repository.DeptEmpDto(d.name, e.ename, e.email) "+ "FROM department d INNER JOIN d.emps e")
	List<DeptEmpDto> fetchEmpDeptDataInnerJoin();

	@Query("SELECT new com.example.joinspring.v1.repository.DeptEmpDto(d.name, e.ename, e.email) "+ "FROM department d, emp e")
	List<DeptEmpDto> fetchEmpDeptDataCrossJoin();
	
}
