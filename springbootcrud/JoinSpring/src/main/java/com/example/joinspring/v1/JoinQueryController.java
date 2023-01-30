package com.example.joinspring.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.joinspring.v1.model.department;

@RestController
public class JoinQueryController {
	
	@Autowired
	private JoinQueryServiceImpl joinQueryService;
	
	@GetMapping("/dept/employees/left")
	public ResponseEntity<List<department>> getDeptEmployeesLeftJoin() {
		return new ResponseEntity<List<department>>(joinQueryService.getDeptEmployeesLeftJoin(), HttpStatus.OK);
	}

	@GetMapping("/dept/employees/right")
	public ResponseEntity<List<DeptEmpDto>> getDeptEmployeesRightJoin() {
		return new ResponseEntity<List<DeptEmpDto>>(joinQueryService.getDeptEmployeesRightJoin(), HttpStatus.OK);
	}

	@GetMapping("/dept/employees/inner")
	public ResponseEntity<List<DeptEmpDto>> getDeptEmployeesInnerJoin() {
		return new ResponseEntity<List<DeptEmpDto>>(joinQueryService.getDeptEmployeesInnerJoin(), HttpStatus.OK);
	}

	@GetMapping("/dept/employees/cross")
	public ResponseEntity<List<DeptEmpDto>> getDeptEmployeesCrossJoin() {
		return new ResponseEntity<List<DeptEmpDto>>(joinQueryService.getDeptEmployeesCrossJoin(), HttpStatus.OK);
	}
	
}
