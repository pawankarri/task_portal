package com.eidiko.employee_service.repository;

import com.eidiko.employee_service.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Exact match
    List<Employee> findByEmpName(String empName);

    // Pattern matching
    @Query("SELECT e FROM Employee e WHERE e.empName LIKE %:empName%")
    List<Employee> searchByEmpNamePattern(@Param("empName") String empName);

    @Query("SELECT e FROM Employee e WHERE e.resigned = TRUE")
    List<Employee> findByResignedTrue();

}
