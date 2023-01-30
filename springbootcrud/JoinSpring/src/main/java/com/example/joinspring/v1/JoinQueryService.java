package com.example.joinspring.v1;

import java.util.List;

import com.example.joinspring.v1.model.department;

public interface JoinQueryService {
	public List<department> getDeptEmployeesLeftJoin();
	public List<DeptEmpDto> getDeptEmployeesRightJoin();
	public List<DeptEmpDto> getDeptEmployeesInnerJoin();
	public List<DeptEmpDto> getDeptEmployeesCrossJoin();
}
