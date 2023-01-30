package com.example.joinspring.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.joinspring.v1.DeptEmpDto;
import com.example.joinspring.v1.model.department;


public interface DepartmentRepository extends JpaRepository<department, Integer>{
	
	@Query("SELECT new com.example.joinspring.v1.repository.DeptEmpDto(d.name, e.ename, e.email) "+ "FROM department d LEFT JOIN d.emps e")
	List<department> fetchEmpDeptDataLeftJoin();

	@Query("SELECT new com.example.joinspring.v1.repository.DeptEmpDto(d.name, e.ename, e.email) "+ "FROM department d RIGHT JOIN d.emps e")
	List<DeptEmpDto> fetchEmpDeptDataRightJoin();
	
}
