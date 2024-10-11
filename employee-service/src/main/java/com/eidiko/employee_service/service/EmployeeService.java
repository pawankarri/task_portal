package com.eidiko.employee_service.service;

import com.eidiko.employee_service.dto.EmployeeDto;
import com.eidiko.employee_service.entity.Employee;


import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    EmployeeDto createEmployee(Employee employee);
    List<EmployeeDto> getAllEmployees();
    Optional<EmployeeDto> getEmployeeById(long id);
    boolean searchEmployeeById(long id);

    List<Employee> searchEmployees(Long empId, String empName);
}
