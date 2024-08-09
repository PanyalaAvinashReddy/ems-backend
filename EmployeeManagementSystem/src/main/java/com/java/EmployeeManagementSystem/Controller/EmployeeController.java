package com.java.EmployeeManagementSystem.Controller;

import com.java.EmployeeManagementSystem.Dto.EmployeeDto;
import com.java.EmployeeManagementSystem.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/EmployeeManagementSystem")
public class EmployeeController {
    private EmployeeService employeeService;

    // Creating new Employee
    @PostMapping("/create")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Get Employees By ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long empId){
        EmployeeDto employeeDto = employeeService.getEmployeeById(empId);
        return ResponseEntity.ok(employeeDto);
    }

    // Delete Employee
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long empId){
        employeeService.deleteById(empId);
    }

    // Get All Employee
    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employee = employeeService.getAllEmployees();
        return ResponseEntity.ok(employee);
    }
    // Update Employee
   @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id,@RequestBody EmployeeDto employeeDto){
        EmployeeDto employeeDto1 = employeeService.updateEmployee(id, employeeDto);
        return ResponseEntity.ok(employeeDto1);
    }
    @PatchMapping("/patch/{id}")
    public ResponseEntity<EmployeeDto> patchUpdateEmployee(@PathVariable Long id,@RequestBody EmployeeDto employeeDto){
        EmployeeDto employeeDto1 = employeeService.updateEmployee(id, employeeDto);
        return ResponseEntity.ok(employeeDto1);
    }
}
