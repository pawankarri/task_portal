package com.eidiko.employee_service.service;

import com.eidiko.employee_service.dto.EmployeeDto;
import com.eidiko.employee_service.entity.Employee;
import com.eidiko.employee_service.exception.EmployeeNotFoundException;
import com.eidiko.employee_service.modelMapper.EmployeeMapper;
import com.eidiko.employee_service.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper;

    @Override
    public EmployeeDto createEmployee(Employee employee) {
        Employee saved = employeeRepository.save(employee);
        return employeeMapper.employeeToEmployeeDto(saved);

    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> listOfEmployees = employeeRepository.findAll();

        return listOfEmployees.
                stream().
                map((emp) -> employeeMapper
                        .employeeToEmployeeDto(emp)).
                        toList();

    }

    @Override
    public Optional<EmployeeDto> getEmployeeById(long id) {
        Employee employee = employeeRepository.findById(id).
                orElseThrow(() -> new EmployeeNotFoundException("employee not found with: " + id));

        EmployeeDto employeeDto = employeeMapper.employeeToEmployeeDto(employee);
        return Optional.ofNullable(employeeDto);

    }


public List<Employee> searchEmployees(Long empId, String empName) {
    if (empId != null) {
        return employeeRepository.findById(empId)
                .map(List::of)
                .orElse(List.of());
    }

    if (empName != null && !empName.isEmpty()) {
        // Check for exact match first
        List<Employee> exactMatches = employeeRepository.findByEmpName(empName);
        if (!exactMatches.isEmpty()) {
            return exactMatches;
        }
        // If no exact match found, perform pattern matching
        return employeeRepository.searchByEmpNamePattern(empName);
    }


    return employeeRepository.findAll();
}

    @Override
    public EmployeeDto updateEmployee(long id, Employee employee) {
        return null;
    }

    @Override
    public EmployeeDto deleteEmployee(long id) {
        return null;
    }
}
