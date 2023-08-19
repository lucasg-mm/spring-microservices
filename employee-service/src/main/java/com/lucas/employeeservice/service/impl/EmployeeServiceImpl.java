package com.lucas.employeeservice.service.impl;

import com.lucas.employeeservice.dto.EmployeeDto;
import com.lucas.employeeservice.entity.Employee;
import com.lucas.employeeservice.mapper.EmployeeMapper;
import com.lucas.employeeservice.repository.EmployeeRepository;
import com.lucas.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.MAPPER.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();

        return EmployeeMapper.MAPPER.mapToEmployeeDto(employee);
    }
}
