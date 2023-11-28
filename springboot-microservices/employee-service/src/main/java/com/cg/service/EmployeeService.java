package com.cg.service;

import com.cg.dto.APIResponseDto;
import com.cg.dto.EmployeeDto;

public interface EmployeeService  {

	 EmployeeDto saveEmployee(EmployeeDto employeeDto);

	 APIResponseDto getEmployeeById(Long employeeId);
	    
}
