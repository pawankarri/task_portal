package com.eidiko.employee_service.service;

import com.eidiko.employee_service.entity.Employee;
import com.eidiko.employee_service.entity.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDetails implements UserDetails {

    private final String emailId;
    private final String password;
    private final List<Role> roles;

    public EmployeeDetails(Employee employee) {
        this.emailId = employee.getEmailId();
        this.password = employee.getPassword();
        this.roles = employee.getEmpRoles();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return emailId;
    }

}
