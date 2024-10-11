package com.eidiko.employee_service.service;

import com.eidiko.employee_service.dto.EmployeeDto;
import com.eidiko.employee_service.entity.Employee;
import com.eidiko.employee_service.repository.EmployeeRepository;
import com.eidiko.employee_service.specification.EmployeeSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(Employee employee) {
        return null;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return List.of();
    }

    @Override
    public Optional<EmployeeDto> getEmployeeById(long id) {
        return Optional.empty();
    }

    @Override
    public boolean searchEmployeeById(long id) {
        return false;
    }

//    public List<Employee> searchEmployees(Long empId, String empName) {
//        Specification<Employee> spec = Specification.where(EmployeeSpecification.hasEmpId(empId))
//                .and(EmployeeSpecification.hasEmpName(empName));
//        return employeeRepository.findAll(spec);
//    }
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

    // If no criteria provided, return all employees or an empty list
    return employeeRepository.findAll();
}
}
