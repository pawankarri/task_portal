package com.eidiko.employee_service.service;

import com.eidiko.employee_service.dto.EmployeeDto;
import com.eidiko.employee_service.entity.Employee;
import com.eidiko.employee_service.exception.EmployeeNotFoundException;
import com.eidiko.employee_service.modelMapper.EmployeeMapper;
import com.eidiko.employee_service.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper;
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        log.info("email: {}", emailId);
        return employeeRepository.findByEmailId(emailId)
                .map(EmployeeDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("employee not found"));
    }

    @Override
    public EmployeeDto createEmployee(Employee employee) {
        employee.setPassword(encoder.encode(employee.getPassword()));
        employee.setEmpRoles(employee.getEmpRoles());
        Employee saved = employeeRepository.save(employee);
        return employeeMapper.employeeToEmployeeDto(saved);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> listOfEmployees = employeeRepository.findAll();

        return listOfEmployees.
                stream()
                .map((emp) -> employeeMapper.employeeToEmployeeDto(emp))
                .toList();
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).
                orElseThrow(() -> new EmployeeNotFoundException("employee not found with: " + id));

        return employeeMapper.employeeToEmployeeDto(employee);
    }


    public List<Employee> searchEmployees(Long empId, String empName) {
        if (empId != null)
            return List.of(employeeRepository.findByEmpNameOrEmpId(empName, empId)
                    .orElseThrow(() -> new EmployeeNotFoundException("employee not found")));

        // If no exact match found, perform pattern matching
        return employeeRepository.searchByEmpNamePattern(empName);
    }

    @Override
    public EmployeeDto updateEmployee(long id, Employee employee) {
        Employee employees=employeeRepository.findById(id).map(employee1 -> {
            employee1.setEmpName(employee.getEmpName());
            employee1.setEmailId(employee.getEmailId());
            employee1.setAbout(employee.getAbout());
            employee1.setManager(employee.getManager());
            employee1.setPassword(employee.getPassword());
            employee1.setDateOfJoining(employee.getDateOfJoining());
            employee1.setEmpRoles(employee.getEmpRoles());
            employee1.setPhoneNumber(employee.getPhoneNumber());
            employee1.setEmpProfilePicPath(employee.getEmpProfilePicPath());
            employee1.setResigned(employee.isResigned());
            return employeeRepository.save(employee1);
        }).orElseThrow(()->new ResourceAccessException("employee not found"));
        System.out.println(employees);
        return employeeMapper.employeeToEmployeeDto(employees);
    }

    @Override
    public List<EmployeeDto> fetchResignedEmp() {
        return employeeRepository.findByResignedTrue()
                .stream()
                .map(emp -> employeeMapper.employeeToEmployeeDto(emp))
                .toList();
    }

}
