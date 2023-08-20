package com.lucas.employeeservice.service.impl;

import com.lucas.employeeservice.dto.APIResponseDto;
import com.lucas.employeeservice.dto.DepartmentDto;
import com.lucas.employeeservice.dto.EmployeeDto;
import com.lucas.employeeservice.entity.Employee;
import com.lucas.employeeservice.exception.ResourceNotFoundException;
import com.lucas.employeeservice.mapper.EmployeeMapper;
import com.lucas.employeeservice.repository.EmployeeRepository;
import com.lucas.employeeservice.service.APIClient;
import com.lucas.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        System.out.println(employeeDto.getDepartmentCode());

        Employee employee = EmployeeMapper.MAPPER.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository
                .findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId.toString()));

        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());
        EmployeeDto employeeDto = EmployeeMapper.MAPPER.mapToEmployeeDto(employee);

        return new APIResponseDto(employeeDto, departmentDto);
    }
}
