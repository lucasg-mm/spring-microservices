package com.lucas.departmentservice.service.impl;

import com.lucas.departmentservice.dto.DepartmentDto;
import com.lucas.departmentservice.entity.Department;
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
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode());

        Department savedDepartment = departmentRepository.save(department);

        return new DepartmentDto(
                savedDepartment.getId(),
                savedDepartment.getDepartmentName(),
                savedDepartment.getDepartmentDescription(),
                savedDepartment.getDepartmentCode()
        );
    }
}
