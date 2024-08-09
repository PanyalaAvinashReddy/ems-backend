package com.java.EmployeeManagementSystem.Mapper;

import com.java.EmployeeManagementSystem.Dto.EmployeeDto;
import com.java.EmployeeManagementSystem.Entity.Employee;

public class EmployeeMapper {

    //Mapping Employee Dto to Employee entity
    public static EmployeeDto mapEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getMobile(),
                employee.getAddress()
        );
    }

    //Mapping Employee Entity to Employee DTO

    public static Employee mapEmployee(EmployeeDto employeeDto){
        return  new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getMobile(),
                employeeDto.getAddress()
        );
    }
}
