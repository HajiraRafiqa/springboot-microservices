package com.cg.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.cg.dto.DepartmentDto;
import com.cg.entity.Department;
import com.cg.mapper.DepartmentMapper;
import com.cg.repository.DepartmentRepository;

class DepartmentServiceImplTest {
	
	private DepartmentRepository departmentRepository;
	private DepartmentServiceImpl departmentservice;

	@BeforeEach
	void setUp() throws Exception {
		
		departmentRepository = Mockito.mock(DepartmentRepository.class);
		departmentservice = new DepartmentServiceImpl(departmentRepository);
	}

	@Test
	void saveDepartment() {
		Department department = new Department();
		department.setId((long)2);
		department.setDepartmentName("Science");
		department.setDepartmentDescription("Science Dept");
		department.setDepartmentCode("002");
		
		
		DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(department);
		
		assertThrows(NullPointerException.class, () -> departmentservice.saveDepartment(savedDepartmentDto));
	}
	
	@Test
	void getDepartmentByCode() {
		
		Department department = departmentRepository.findByDepartmentCode("001");

        DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);
        
        
		
		
	}

}
