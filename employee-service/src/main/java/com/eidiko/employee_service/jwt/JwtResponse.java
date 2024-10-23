package com.eidiko.employee_service.jwt;

import com.eidiko.employee_service.dto.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {

    private String token;
    private EmployeeDto employeeDto;

}