package com.example.joinspring.v1;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.joinspring.v1.model.department;
import com.example.joinspring.v1.repository.DepartmentRepository;
import com.example.joinspring.v1.repository.EmployeeRepository;

import jakarta.annotation.Resource;

@Service
public class JoinQueryServiceImpl implements JoinQueryService{
	@Resource
	private DepartmentRepository departmentRepository;

	@Resource
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<department> getDeptEmployeesLeftJoin() {
		List<department> list = departmentRepository.fetchEmpDeptDataLeftJoin();
		list.forEach(l -> System.out.println(l));
		return list;
	}
	@Override
	public List<DeptEmpDto> getDeptEmployeesRightJoin() {
		List<DeptEmpDto> list = departmentRepository.fetchEmpDeptDataRightJoin();
		list.forEach(l -> System.out.println(l));
		return list;
	}
	@Override
	public List<DeptEmpDto> getDeptEmployeesInnerJoin() {
		List<DeptEmpDto> list = employeeRepository.fetchEmpDeptDataInnerJoin();
		list.forEach(l -> System.out.println(l));
		return list;
	}
	@Override
	public List<DeptEmpDto> getDeptEmployeesCrossJoin() {
		List<DeptEmpDto> list = employeeRepository.fetchEmpDeptDataCrossJoin();
		list.forEach(l -> System.out.println(l));
		return list;
	}
}
