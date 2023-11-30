package com.cg.service.impl;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.cg.dto.DepartmentDto;
import com.cg.entity.Department;
import com.cg.mapper.DepartmentMapper;
import com.cg.repository.DepartmentRepository;
import com.cg.service.DepartmentService;
import lombok.AllArgsConstructor;



@Service
@AllArgsConstructor

public class DepartmentServiceImpl implements DepartmentService {
	

    private DepartmentRepository departmentRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
    	LOGGER.info("saving department");

        // convert department dto to department jpa entity
        Department department = DepartmentMapper.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);

        return departmentDto;
    }

}
