package com.java.EmployeeManagementSystem.Service.impl;

import com.java.EmployeeManagementSystem.Dto.EmployeeDto;
import com.java.EmployeeManagementSystem.Entity.Employee;
import com.java.EmployeeManagementSystem.Exception.ResourceNotFoundException;
import com.java.EmployeeManagementSystem.Mapper.EmployeeMapper;
import com.java.EmployeeManagementSystem.Repository.EmployeeRepo;
import com.java.EmployeeManagementSystem.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceimpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapEmployee(employeeDto);
        Employee savedEmployee = employeeRepo.save(employee);
        return EmployeeMapper.mapEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long empId) {
        Employee employeeId = employeeRepo.findById(empId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not find with given ID :"+ empId));
        return EmployeeMapper.mapEmployeeDto(employeeId);
    }

    @Override
    public void deleteById(Long empId) {
        employeeRepo.deleteById(empId);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = employeeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Id Not Found: "+id));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setMobile(employeeDto.getMobile());
        employee.setAddress(employeeDto.getAddress());
        Employee employee1 = employeeRepo.save(employee);
        return EmployeeMapper.mapEmployeeDto(employee1);
    }

    @Override
    public EmployeeDto addAddress(Long id, EmployeeDto employeeDto) {
        return null;
    }


}
