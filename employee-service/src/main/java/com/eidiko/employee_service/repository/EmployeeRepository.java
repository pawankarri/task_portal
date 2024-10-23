package com.eidiko.employee_service.repository;

import com.eidiko.employee_service.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmailId(String emailId);

    Optional<Employee> findByEmpNameOrEmpId(String empName, Long empId);

    // Pattern matching
    @Query("SELECT e FROM Employee e WHERE e.empName LIKE %:empName%")
    List<Employee> searchByEmpNamePattern(@Param("empName") String empName);

    @Query("SELECT e FROM Employee e WHERE e.resigned = TRUE")
    List<Employee> findByResignedTrue();

}
