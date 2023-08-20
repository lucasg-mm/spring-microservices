package com.lucas.employeeservice.service;

import com.lucas.employeeservice.dto.APIResponseDto;
import com.lucas.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
