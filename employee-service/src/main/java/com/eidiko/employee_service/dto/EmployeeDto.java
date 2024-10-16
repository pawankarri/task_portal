package com.eidiko.employee_service.dto;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {

    private long empId;
    private String empName;
    private String emailId;
    private String phoneNumber;
    private LocalDate dateOfJoining;
    private boolean isResigned;
    private String about;

    // Employee roles
    private List<RoleDto> empRoles;

    // Designation and Band
    private DesignationAndBandDto designation;

    // Profile picture path
    private String empProfilePicPath;


//    private List<Long> reportingManagerForEmployee;
//
//    private List<Long> reportingManagerForManager;

}

