package com.eidiko.employee_service.specification;

import com.eidiko.employee_service.entity.Employee;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecification {
    public static Specification<Employee> hasEmpId(Long empId) {
        return (root, query, criteriaBuilder) -> empId == null ? null : criteriaBuilder.equal(root.get("empId"), empId);
    }

    public static Specification<Employee> hasEmpName(String empName) {
        return (root, query, criteriaBuilder) -> empName == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("empName")), "%" + empName.toLowerCase() + "%");
    }
}
