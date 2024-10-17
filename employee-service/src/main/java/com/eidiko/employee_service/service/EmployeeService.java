package com.eidiko.employee_service.service;

import com.eidiko.employee_service.dto.EmployeeDto;
import com.eidiko.employee_service.entity.Employee;


import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(Employee employee);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto getEmployeeById(Long id);

    List<Employee> searchEmployees(Long empId, String empName);

    EmployeeDto updateEmployee(long id, Employee  employee);

    List<EmployeeDto> fetchResignedEmp();

}
