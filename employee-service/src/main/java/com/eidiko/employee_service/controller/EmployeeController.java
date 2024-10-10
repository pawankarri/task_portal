package com.eidiko.employee_service.controller;

import com.eidiko.employee_service.entity.Employee;
import com.eidiko.employee_service.repository.EmployeeRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeRepository employeeRepository;
    @PostMapping()
    public Employee createEmployee(@Valid @RequestBody Employee employee){

      return employeeRepository.save(employee);
    }
}
