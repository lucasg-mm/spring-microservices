package com.lucas.departmentservice.service.impl;

import com.lucas.departmentservice.dto.DepartmentDto;
import com.lucas.departmentservice.entity.Department;
import com.lucas.departmentservice.mapper.DepartmentMapper;
import com.lucas.departmentservice.repository.DepartmentRepository;
import com.lucas.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.MAPPER.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        return DepartmentMapper.MAPPER.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        return DepartmentMapper.MAPPER.mapToDepartmentDto(department);
    }
}
