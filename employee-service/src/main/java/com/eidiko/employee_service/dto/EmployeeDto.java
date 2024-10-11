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

    @NotBlank(message = "Employee name is mandatory")
    @Size(min = 3, max = 100, message = "Employee name must be between 3 and 100 characters")
    private String empName;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    private String emailId;

    @NotBlank(message = "Contact number is mandatory")
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Invalid phone number")
    private String phoneNumber;

    @NotNull(message = "Date of joining is required")
    private LocalDate dateOfJoining;

    private boolean isResigned;

    @Size(max = 500, message = "About section must be less than 500 characters")
    private String about;

    // LoginDetails info
    private LoginDetailsDto loginDetails;

    // Employee roles
    private List<RoleDto> empRoles;

    // Designation and Band
    private DesignationAndBandDto designation;

    // Profile picture path
    private String empProfilePicPath;


    private List<Long> reportingManagerForEmployee;

    private List<Long> reportingManagerForManager;

}

