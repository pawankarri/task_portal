package com.eidiko.employee_service.controller;

import com.eidiko.employee_service.dto.EmployeeDto;
import com.eidiko.employee_service.entity.Employee;
import com.eidiko.employee_service.exception.EmployeeNotFoundException;
import com.eidiko.employee_service.repository.EmployeeRepository;
import com.eidiko.employee_service.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
@Slf4j
public class EmployeeController {

    private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;

    @PostMapping("/addEmployees")
    public EmployeeDto createEmployee(@Valid @RequestBody Employee employee){
      return employeeService.createEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        List<Employee> all = employeeRepository.findAll();

        log.info("list of employee {}" ,all.size());
        //System.out.println("list of employee {}" + all);
        return all;
    }
 @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable long id){
       return  employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("employee not found"));
    }

    @GetMapping("/search")
    public List<Employee> searchEmployees(
            @RequestParam(required = false) Long empId,
            @RequestParam(required = false) String empName) {
        return employeeService.searchEmployees(empId, empName);
    }
}
