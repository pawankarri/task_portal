package com.eidiko.employee_service.controller;

import com.eidiko.employee_service.dto.EmployeeDto;
import com.eidiko.employee_service.entity.Employee;
import com.eidiko.employee_service.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
@Slf4j
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public EmployeeDto createEmployee(@Valid @RequestBody Employee employee) {
      return employeeService.createEmployee(employee);
    }

    @GetMapping("/get")
    @PreAuthorize("hasRole('ROLE_HR')")
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_HR')")
    public EmployeeDto getEmployeeById(@PathVariable long id) {
       return employeeService.getEmployeeById(id);
    }

    @GetMapping("/search")
    public List<Employee> searchEmployees(
            @RequestParam(required = false) Long empId,
            @RequestParam(required = false) String empName) {
        return employeeService.searchEmployees(empId, empName);
    }

    @GetMapping("/resigned")
    public List<EmployeeDto> getAllResignedEmp() {
        return employeeService.fetchResignedEmp();
    }

    @PutMapping("/updateEmployee/{id}")
    public EmployeeDto updateEmployee(@PathVariable long id,@RequestBody Employee employee) {
        return employeeService.updateEmployee(id,employee);
    }

}
