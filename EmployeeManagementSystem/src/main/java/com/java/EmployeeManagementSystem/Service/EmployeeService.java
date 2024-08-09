package com.java.EmployeeManagementSystem.Service;

import com.java.EmployeeManagementSystem.Dto.EmployeeDto;
import com.java.EmployeeManagementSystem.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long empId);

    void deleteById(Long empId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long id,EmployeeDto employeeDto);

    EmployeeDto addAddress(Long id,EmployeeDto employeeDto);
}
